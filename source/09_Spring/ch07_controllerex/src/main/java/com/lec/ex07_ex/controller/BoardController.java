package com.lec.ex07_ex.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ex07_ex.Member;

@Controller
@RequestMapping("board")
public class BoardController {
	@RequestMapping(value="write")
	public String write() {
		return "board/write";
	}
	@RequestMapping(value= "content")
	public String content(Model model) {
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "zzz");
		Member member = new Member("ccc", "ㄹㅇ인가");
		model.addAttribute("member", member);
		return "board/content";
	}
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public ModelAndView list () {
		ModelAndView mav = new ModelAndView();
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("aaa", "111"));
		list.add(new Member("bbb", "222"));
		list.add(new Member("ccc", "333"));
		mav.addObject("list", list);
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(ModelAndView mav) {
		Member member = new Member("aaa", "111");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;		
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
		public String reply (Model model) {
		model.addAttribute("result", "reply(POST)완료 ");
		return "board/result";
	}	
}
