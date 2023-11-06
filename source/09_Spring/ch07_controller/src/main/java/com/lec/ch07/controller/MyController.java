package com.lec.ch07.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	// http://localhost:8090/ch07/의 요청경로 처리 로직
	@RequestMapping("/")
	public String home(Model model) {
		logger.info("메인으로 감");
		return "main";
		// main.jsp로 감. 따라서 main.jsp 필요
	}
}
