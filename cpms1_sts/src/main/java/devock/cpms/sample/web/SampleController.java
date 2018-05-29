package devock.cpms.sample.web;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import devock.cpms.etc.service.EtcService;
import devock.cpms.sample.service.SampleService;

@Controller

public class SampleController {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "sampleService")
	private SampleService sampleService;

	@Resource(name = "etcService")
	private EtcService etcvService;

	/**
	 * 
	 * 조직도/사용자 선택 샘플.
	 * 
	 * @throws Exception
	 * 
	 */

	@RequestMapping(value = "/sample1.do")
	public String sample1(HttpServletRequest request, ModelMap modelMap) throws Exception {

		// String userno = request.getSession().getAttribute("userno").toString();

		String userno = "1";

		Integer alertcount = etcvService.selectAlertCount(userno);

		modelMap.addAttribute("alertcount", alertcount);

		return "main/sample1";

	}

}
