package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.repository.MemberDao;
import com.lec.ch19.service.MemberService;
import com.lec.ch19.vo.Member;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String mid, String mpw, String after, Model model, HttpSession httpSession) {
		String msg = memberService.loginCheck(mid, mpw, httpSession);
		if (msg.equals("로그인 되었습니다")) {
			model.addAttribute("loginResult", msg);
			return "redirect:../" + after;
		} else {
			model.addAttribute("loginResult", msg);
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			return "member/login";
		}		
	}
	
	@RequestMapping(value = "idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("idConfirmResult", memberService.idConfirm(mid));
		return "member/idConfirm";
	}
	
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {		
		httpSession.invalidate();
		model.addAttribute("logoutResult", "로그아웃 되었습니다.");		
		return "forward:../main.do";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify() {
		return "member/modify";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("mDto") Member member, HttpSession httpSession, Model model) {
		model.addAttribute("modifyResult", memberService.modifyMember(member, httpSession));
		return "forward:../main.do";		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		return "member/join";		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mDto") Member member, Model model, HttpSession httpSession) {
		model.addAttribute("joinResult", memberService.joinMember(member, httpSession));
		return "member/login";	
	}
	
}
