package com.lec.ch08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	// 모든 요청경로의 jsp 페이지에 출력할 내용. ex)쿠팡 장바구니
	@ModelAttribute("cnt")
	public int cnt () {
		return 5;		
	}
	// ModelAttribute는 여러개 추가 가능
	@ModelAttribute("list")
	public ArrayList<String> list () {
		ArrayList<String> lists = new ArrayList<String>();
		lists.add("홍길동");
		lists.add("홀길순");
		return lists;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String input() {
		return "member/input";
	}
	
//	@RequestMapping(value = "studentId/{id}", method = RequestMethod.GET)
//	public String StudentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		String uri = request.getRequestURI(); //  /ch09/studentId/aaa
//		// 패러미터만 따로 추출하기 위해서는 uri에서 맨 마지막 슬래시를 찾으면 된다.
//		String id = uri.substring(uri.lastIndexOf("/")+1);
//		id = URLEncoder.encode(id, "utf-8");
//		// 슬래시 다음부터 맨 마지막 글자까지 (, 입력 x시 마지막까지)
//		System.out.println("넘어온 변수는" + id);
//		model.addAttribute("id",id);
//		return "studentId";		
//	}
	
	@RequestMapping(value = "studentId/{id}", method = RequestMethod.GET)
	public String StudentId(@PathVariable("id") String id, Model model){
		model.addAttribute("id", id);
		return "studentId";		
	}	
}
