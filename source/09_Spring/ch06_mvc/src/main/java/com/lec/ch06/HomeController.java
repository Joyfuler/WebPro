package com.lec.ch06;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		String greeting = "안녕하세요, 스프링";
		model.addAttribute("greeting", greeting);
		System.out.println(greeting);
		logger.info(greeting);
		logger.warn(greeting);
		logger.error(greeting);
		return "home";
	// 이 home이 controller에 돌아가서 앞에 WEB-INF/views/ 가 붙고, 뒤에 .jsp가 붙음.
	// 결과 view 단에서의 경로는 WEB-INF/views/home.jsp 가 된다.	
	}
	
}
