package devock.cpms.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import devock.cpms.admin.board.service.BoardGroupService;
import devock.cpms.admin.board.service.BoardGroupVO;
import devock.cpms.board.service.BoardSearchVO;
import devock.cpms.board.service.BoardService;
import devock.cpms.board.service.BoardVO;
import devock.cpms.common.logger.LoggerInterceptor;
import devock.cpms.common.util.FileUtil;
import devock.cpms.common.util.TreeMaker;
import devock.cpms.common.vo.Field3VO;
import devock.cpms.common.vo.FileVO;
import devock.cpms.etc.service.EtcService;

@Controller
public class BoardController {
	
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private EtcService etcService;
	
	@Autowired
	private BoardGroupService boardGroupService;	
	
	
	
	/**
     * 리스트.
     */
    @RequestMapping(value = "/boardList.do")
    public String boardList(HttpServletRequest request, BoardSearchVO searchVO, ModelMap modelMap) throws Exception {
    	
    	//System.out.println("boardList Start");
    	
        String globalKeyword = request.getParameter("globalKeyword");  // it's search from left side bar
        
        if (globalKeyword!=null & !"".equals(globalKeyword)) {
            searchVO.setSearchKeyword(globalKeyword);
        }        
        
        String userno = request.getSession().getAttribute("userno").toString();
        
        Integer alertcount = etcService.selectAlertCount(userno);
        modelMap.addAttribute("alertcount", alertcount);
        
        if (searchVO.getBgno() != null && !"".equals(searchVO.getBgno())) {
            BoardGroupVO bgInfo = boardService.selectBoardGroupOne4Used(searchVO.getBgno());
            if (bgInfo == null) { 
                return "board/BoardGroupFail";
            }
            modelMap.addAttribute("bgInfo", bgInfo);
        }
        
        List<?> noticelist  = boardService.selectNoticeList(searchVO);

        searchVO.pageCalculate( boardService.selectBoardCount(searchVO) ); // startRow, endRow
        List<?> listview  = boardService.selectBoardList(searchVO);
        
        modelMap.addAttribute("searchVO", searchVO);
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("noticelist", noticelist);
        
        if (searchVO.getBgno() == null || "".equals(searchVO.getBgno())) {
            return "board/BoardListAll";
        }
        return "board/BoardList";
    }
    
    /** 
     * 글 쓰기. 
     */
    @RequestMapping(value = "/boardForm.do")
    public String boardForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
        String userno = request.getSession().getAttribute("userno").toString();
        
        Integer alertcount = etcService.selectAlertCount(userno);
        modelMap.addAttribute("alertcount", alertcount);
        
        String bgno = request.getParameter("bgno");
        String brdno = request.getParameter("brdno");
        
        if (brdno != null) {
            BoardVO boardInfo = boardService.selectBoardOne(new Field3VO(brdno, null, null));
            List<?> listview = boardService.selectBoardFileList(brdno);
        
            modelMap.addAttribute("boardInfo", boardInfo);
            modelMap.addAttribute("listview", listview);
            bgno = boardInfo.getBgno();
        }
        BoardGroupVO bgInfo = boardService.selectBoardGroupOne4Used(bgno);
        if (bgInfo == null) {
            return "board/BoardGroupFail";
        }
        
        modelMap.addAttribute("bgno", bgno);
        modelMap.addAttribute("bgInfo", bgInfo);
        
        return "board/BoardForm";
    }
    
    /**
     * 글 저장.
     */
    @RequestMapping(value = "/boardSave.do")
    public String boardSave(HttpServletRequest request, BoardVO boardInfo) throws Exception {
        String userno = request.getSession().getAttribute("userno").toString();
        boardInfo.setUserno(userno);
        
        System.out.println("boardInfo >> " + boardInfo);

        if (boardInfo.getBrdno() != null && !"".equals(boardInfo.getBrdno())) {    // check auth for update
            String chk = boardService.selectBoardAuthChk(boardInfo);
            if (chk == null) {
                return "common/noAuth";
            }
        }
       
        String[] fileno = request.getParameterValues("fileno");
        FileUtil fs = new FileUtil();
        List<FileVO> filelist = fs.saveAllFiles(boardInfo.getUploadfile());

        boardService.insertBoard(boardInfo, filelist, fileno);

        return "redirect:/boardList.do?bgno=" + boardInfo.getBgno();
    }
    
    /**
     * 글 읽기.
     */
    @RequestMapping(value = "/boardRead.do")
    public String boardRead(HttpServletRequest request, ModelMap modelMap) throws Exception {
        String userno = request.getSession().getAttribute("userno").toString();
        
        Integer alertcount = etcService.selectAlertCount(userno);
        modelMap.addAttribute("alertcount", alertcount);
        
        String bgno = request.getParameter("bgno");
        String brdno = request.getParameter("brdno");
        
        Field3VO f3 = new Field3VO(brdno, userno, null);
        
        boardService.updateBoardRead(f3);
        BoardVO boardInfo = boardService.selectBoardOne(f3);
        List<?> listview = boardService.selectBoardFileList(brdno);
        // 답변 임시 주석
        //List<?> replylist = boardService.selectBoardReplyList(brdno);

        BoardGroupVO bgInfo = boardService.selectBoardGroupOne4Used(boardInfo.getBgno());
        if (bgInfo == null) {
            return "board/BoardGroupFail";
        }
        
        modelMap.addAttribute("boardInfo", boardInfo);
        modelMap.addAttribute("listview", listview);
        //modelMap.addAttribute("replylist", replylist);
        modelMap.addAttribute("bgno", bgno);
        modelMap.addAttribute("bgInfo", bgInfo);
        
        return "board/BoardRead";
    }
    
    /**
     * 게시판 트리. Ajax용.     
     */
    @RequestMapping(value = "/boardListByAjax.do")
    public void boardListByAjax(HttpServletResponse response, ModelMap modelMap) throws Exception {
	    List<?> listview   = boardGroupService.selectBoardGroupList();
	
	    TreeMaker tm = new TreeMaker();
	    String treeStr = tm.makeTreeByHierarchy(listview);
	    
	    response.setContentType("application/json;charset=UTF-8");
	    try {
	        response.getWriter().print(treeStr);
	    } catch (IOException ex) {
	    	log.error("boardListByAjax");
	    }
	        
    }

}
