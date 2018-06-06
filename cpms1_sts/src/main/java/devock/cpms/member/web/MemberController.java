package devock.cpms.member.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import devock.cpms.admin.organ.service.UserService;
import devock.cpms.common.util.JsonUtil;
import devock.cpms.common.validator.UserVoValidator;
import devock.cpms.common.vo.SearchVO;
import devock.cpms.member.service.MemberService;
import devock.cpms.member.service.UserVO;

@Controller
public class MemberController {
	
	@Resource(name = "userVoValidator")
	private UserVoValidator validator;

	@Autowired
	private UserService userService;

	@Autowired
	private MemberService memberService;
	
//	@Autowired
//	private UserVoValidator validator;

	// 내 정보
	@RequestMapping(value = "/memberForm.do")
	public String memberForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
		
		String save = request.getParameter("save");
		String userno = request.getSession().getAttribute("userno").toString();
		UserVO userInfo = userService.selectUserOne(userno);
		
		modelMap.addAttribute("userInfo", userInfo);
		modelMap.addAttribute("save", save);
		
		return "member/memberForm.tiles";
	}
	

	/**
     * 사용자 저장.
   
    @RequestMapping(value = "/userSave.do" , produces = "application/json; charset=utf-8")
    @ResponseBody
    public String userSave(HttpServletRequest request, ModelMap modelMap, UserVO userInfo) throws Exception {
    		
        String userno = request.getSession().getAttribute("userno").toString();
        userInfo.setUserno(userno);
        
        FileUtil fs = new FileUtil();
        FileVO fileInfo = fs.saveImage(userInfo.getPhotofile());
        
        if (fileInfo != null) {
            userInfo.setPhoto(fileInfo.getRealname());
        }
        userService.updateUserByMe(userInfo);

        return "redirect:/memberForm.do?save=OK";
    }
      */
    
	
	 /**
     * 비밀번호 변경.
     */
    @RequestMapping(value = "/changePWSave.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String changePWSave(HttpServletRequest request, HttpServletResponse response, UserVO userInfo) throws Exception {
        String result = "";
    	
    	String userno = request.getSession().getAttribute("userno").toString();
        //userInfo.setUserno(userno);
        
        userService.updateUserPassword(userInfo);
        
        result ="OK";
   
        return JsonUtil.OneStringToJson(result);
    }
	
	/**
     * 직원조회.
     */
    @RequestMapping(value = "/searchMember.do")
    public String searchMember(SearchVO searchVO, ModelMap modelMap) throws Exception {
        
        if (searchVO.getSearchKeyword() != null & !"".equals(searchVO.getSearchKeyword())) {
            searchVO.pageCalculate( memberService.selectSearchMemberCount(searchVO) ); // startRow, endRow
            
            List<?> listview = memberService.selectSearchMemberList(searchVO);
        
            modelMap.addAttribute("listview", listview);
        }
        modelMap.addAttribute("searchVO", searchVO);
        
        return "member/searchMember.tiles";
    }
    
    /**
     * 회원가입
     */
    @RequestMapping(value = "/memberJoin.do")
    public String memberJoin(@ModelAttribute UserVO userVO) throws Exception {
    	
    	return "member/memberJoin.tiles";
    }
    
    @RequestMapping(value = "/memberJoinValidChk.do")
    public String memberJoinValidChk(@ModelAttribute @Valid UserVO userVO, 
    		BindingResult result, ModelMap model) throws Exception {
    	
    	System.out.println("memberJoinValidChk");
    	
    	//System.out.println("에러여부 >> " + bindingResult.hasErrors());
    	
    	validator.validate(userVO, result);
    	
    	return "member/memberJoin.tiles";
    }
    
}
