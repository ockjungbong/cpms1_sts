package devock.cpms.main.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	/**
     * 조직도/사용자 선택 샘플. 
     */
    @RequestMapping(value = "/sample1.do")
    public String sample1(HttpServletRequest request, ModelMap modelMap) {
        String userno = request.getSession().getAttribute("userno").toString();
        
//        Integer alertcount = etcSvc.selectAlertCount(userno);
//        modelMap.addAttribute("alertcount", alertcount);
        
        return "main/sample1";
    }

}
