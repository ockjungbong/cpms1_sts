package devock.cpms.main.web;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	@RequestMapping(value = "main.do")
	public String main() throws Exception {		
		
		return "main/main.tiles";
	}
}
