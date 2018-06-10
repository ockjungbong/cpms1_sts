package devock.cpms.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import devock.cpms.admin.board.BoardGroupVO;
import devock.cpms.board.service.BoardSearchVO;
import devock.cpms.board.service.BoardService;
import devock.cpms.common.logger.LoggerInterceptor;
import devock.cpms.etc.service.EtcService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private EtcService etcService;
	
	
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	/**
     * 리스트.
     */
    @RequestMapping(value = "/boardList.do")
    public String boardList(HttpServletRequest request, BoardSearchVO searchVO, ModelMap modelMap) throws Exception {
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

}
