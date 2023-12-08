package com.lec.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HelloController {
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("greeting", "Hello, Spring Boot");
		log.info("첫화면으로 감");
		return "index"; //기존 스프링의 경우, WEB-INF/views/index.jsp로 갔었음.
		// SpringBoot에서는 templates/index.html로 이동함.
		// welcome page 우선순위 - 컨트롤러 > static/index.html
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("data", "어서와 부트는 처음이지");
		return "hello";
		// 기본적으로 templates/hello.html
	}
	
}
