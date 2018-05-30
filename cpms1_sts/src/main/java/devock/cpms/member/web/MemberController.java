package devock.cpms.member.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import devock.cpms.admin.organ.service.UserService;
import devock.cpms.member.service.MemberService;
import devock.cpms.member.service.UserVO;

@Controller
public class MemberController {

	@Autowired
	private UserService userService;

	@Autowired
	private MemberService memberService;

	// 내 정보
	@RequestMapping(value = "/memberForm.do")
	public String memberForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
		
		String save = request.getParameter("save");
		String userno = request.getSession().getAttribute("userno").toString();
		UserVO userInfo = userService.selectUserOne(userno);
		
		modelMap.addAttribute("userInfo", userInfo);
		modelMap.addAttribute("save", save);
		
		return "member/memberForm";
	}
}
