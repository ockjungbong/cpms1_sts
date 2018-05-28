package devock.cpms.main.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import devock.cpms.logger.LoggerInterceptor;

@Controller
public class MainController {
	
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	

	
	
	@RequestMapping(value = "main.do")
	public String main() throws Exception {	
		log.debug("인터셉터 테스트");
		
		return "main/main.tiles";
	}
}
