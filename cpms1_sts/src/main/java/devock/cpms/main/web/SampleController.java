package devock.cpms.main.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import devock.cpms.etc.service.EtcService;


@Controller
public class SampleController {
	
	@Autowired
    private EtcService etcService;
	
	/**
     * 조직도/사용자 선택 샘플. 
     */
    @RequestMapping(value = "/sample1.do")
    public String sample1(HttpServletRequest request, ModelMap modelMap) throws Exception {
        String userno = request.getSession().getAttribute("userno").toString();
        
       Integer alertcount = etcService.selectAlertCount(userno);
       modelMap.addAttribute("alertcount", alertcount);
        
        return "main/sample1";
    }

}
