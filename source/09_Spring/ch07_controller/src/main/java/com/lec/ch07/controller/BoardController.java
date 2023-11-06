package com.lec.ch07.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// write / content / list / reply
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.cho07.dto.Member;
@Controller
@RequestMapping("board") // 공통 요청경로
public class BoardController {
	@RequestMapping(value = "/write", method = RequestMethod.GET) // board/write
	// 기본 메소드는 get방식. get인 경우는 추가할 필요 없음. 만일 post라면 뒤에 추가해 주어야 함.
	public String write() {		
		return "board/write";
		// 뷰페이지는 WEB-INF/view/board/write.jsp
	}
	
	@RequestMapping(value = "/content", method = RequestMethod.GET) // board/content
	public String content(Model model) {
		model.addAttribute("id","aaa");
		model.addAttribute("pw","111");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member);
		return "board/content";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String list(Model model) {
//		ArrayList<Member> list = new ArrayList<Member>();
//		list.add(new Member("장장진", "adad"));
//		list.add(new Member("김장앤","abab"));
//		model.addAttribute("list", list);
//		return "board/list";
//      기존방식	
	public ModelAndView list (Model model) {
		ModelAndView mav = new ModelAndView();
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("장장진", "adad"));
		list.add(new Member("김장앤","abab"));
		list.add(new Member("킴킴스", "kks"));
		mav.addObject("list", list);
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(ModelAndView mav) {
		Member member = new Member("ㅊㅊㅊ", "ㅅㅅㅅ");
		mav.addObject(member);
		mav.setViewName("board/reply");
		return mav;
	}	
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(Model model) {
		model.addAttribute("result", "reply(POST)완료");
		return "board/result";
	}	
}
