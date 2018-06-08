package devock.cpms.main.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import devock.cpms.common.util.Util4calen;
import devock.cpms.etc.service.EtcService;
import devock.cpms.main.service.SampleService;


@Controller
public class SampleController {
	
	@Autowired
    private EtcService etcService;
	
	@Autowired
    private SampleService sampleService;
	
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
    
    /**
     * 날짜 선택 샘플. 
     */
    @RequestMapping(value = "/sample2.do")
    public String sample2(HttpServletRequest request, ModelMap modelMap) throws Exception {
        String userno = request.getSession().getAttribute("userno").toString();
        
        Integer alertcount = etcService.selectAlertCount(userno);
        modelMap.addAttribute("alertcount", alertcount);
        // -----------------------------------------
        
        String today = Util4calen.date2Str(Util4calen.getToday());
        
        modelMap.addAttribute("today", today);
        return "main/sample2";
    }
    
    /**
     * 챠트 사용 샘플. 
     */
    @RequestMapping(value = "/sample3")
    public String sample3(HttpServletRequest request, ModelMap modelMap) throws Exception {
        String userno = request.getSession().getAttribute("userno").toString();
        
        Integer alertcount = etcService.selectAlertCount(userno);
        modelMap.addAttribute("alertcount", alertcount);
        // -----------------------------------------
        
        List<?> listview = sampleService.selectBoardGroupCount4Statistic();
        modelMap.addAttribute("listview", listview);
        
        return "main/sample3";
    }

}
