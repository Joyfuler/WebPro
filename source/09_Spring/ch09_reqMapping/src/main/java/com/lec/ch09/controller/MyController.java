package com.lec.ch09.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	@RequestMapping(value="main", method = RequestMethod.GET)
	// main.do 요청. 생략 가능
	public String main() {
		return "main";
	}
	
	// get과 post 한번에 처리
//	@RequestMapping(value = "student")
//	public String Student(String id, Model model, HttpServletRequest request) { // 자동으로 담겨 보내짐
//		String method = request.getMethod(); // post인지 get인지를 확인 가능.
//		logger.info("들어온 요청 방식은" + method);
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	
	@RequestMapping(value = "student", method = RequestMethod.GET)
	public String student(String id, Model model) {
		logger.info("들어온 요청 방식은  get");		
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value = "student", method = RequestMethod.POST)
	public String student(Model model, String id) {
		logger.info("들어온 요청 방식은  post");		
		model.addAttribute("id", id);
		return "studentId";
	}
	
	@RequestMapping(value = "studentOk", method = RequestMethod.GET)
	public String studentOk() { // 패러미터 전달 없이 주소만 이동
		return "studentOk";
	}
	
	@RequestMapping(value = "studentOk", method = RequestMethod.POST)
	public String studentPostOk(String id, Model model) { // 패러미터 전달 없이 주소만 이동
		model.addAttribute("id",id);
		return "studentOk";
	}
	
	@RequestMapping(value = "studentNg", method = RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	
	@RequestMapping(value = "studentNg", method = RequestMethod.POST)
	public ModelAndView studentPostNg(ModelAndView mav) {
		mav.setViewName("studentNg");
		return mav;
	}
	
	@RequestMapping(value = "idConfirm", method = RequestMethod.POST)
	public String idConfirm(String id, Model model) {
		// idConfirm은 form으로부터 반드시 id를 패러미터로 받음.
		model.addAttribute("id",id);
		if (id.equals("aaa")) {
			// 제대로 된 id를 입력한 경우, studentOk.do 요청
			// return studentOk.do"   --> studentOk.do.jsp로 이동함.
			//return "redirect:studentOk.do"; // 새로운 request 객체로 studentOk.do 요청, model에 들어간 id가 소멸함. (GET방식)
			return "forward:studentOk.do"; // request 객체 없이 do 요청함. model 안의 id가 정상적으로 전달됨. (POST방식)
		} else {
			// 제대로 된 id가 아니라면
			//return "redirect:studentNg.do";
			return "forward:studentNg.do";
		}
		
	}
	
	@RequestMapping(value = "fullPath", method = RequestMethod.GET)
	public String fullPath() {
	return "redirect:temp/temp.jsp";
	}
	
}
