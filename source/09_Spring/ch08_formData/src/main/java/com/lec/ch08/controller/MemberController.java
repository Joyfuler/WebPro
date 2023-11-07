package com.lec.ch08.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;
@Controller
@RequestMapping("member") // 공통 경로. 슬래시는 있어도 없어도 상관없음
public class MemberController {
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
	
	@RequestMapping(value = "join1", method = RequestMethod.POST)
	public String join1(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1"; // result.jsp로 이동.		
	}
	
	@RequestMapping(value = "join2", method = RequestMethod.POST)
	public String join2(@RequestParam("name") String mname,
		@RequestParam("id") String mId,
		@RequestParam("pw") String mPw,
		@RequestParam("age") int mAge,
		@RequestParam("email") String mEmail,
		@RequestParam("address") String mAddress,
		Model model) {
		model.addAttribute("name", mname);
		model.addAttribute("id", mId);
		model.addAttribute("pw", mPw);
		model.addAttribute("age", mAge);
		model.addAttribute("email", mEmail);
		model.addAttribute("address", mAddress);
		return "member/result1"; 		
	}
	
	@RequestMapping(value = "join3", method = RequestMethod.GET)
	public String join3(String name, String id, String pw, int age,
		String email, String address, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	
//	@RequestMapping(value = "join4", method = RequestMethod.GET)
//	public String join4(String name, String id, String pw, int age,
//			String email, String address, Model model) {
//		MemberDto member = new MemberDto();
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setAge(age);
//		member.setEmail(email);
//		member.setAddress(address);
//		model.addAttribute("member", member);
//		return "member/result4";
//	}
	
	@RequestMapping(value = "join4", method = RequestMethod.GET)
	public String join4(MemberDto memberDto, Model model) {
		model.addAttribute("member", memberDto);
		return "member/result4";
	}
	
	@RequestMapping(value = "join5", method = RequestMethod.GET)
	public String join5(MemberDto memberDto) {
		//model.addAttribute("memberDto", memberDto) 작업이 자동적용됨
		return "member/result5";		
	}
	
	@RequestMapping(value = "join6", method = RequestMethod.GET)
	public String join6() {
		return "member/result4";
	}
}
