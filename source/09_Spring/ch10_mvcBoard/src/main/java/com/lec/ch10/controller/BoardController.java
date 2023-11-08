package com.lec.ch10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.daovo.BoardmvcDto;
import com.lec.ch10.service.BContentService;
import com.lec.ch10.service.BDeleteService;
import com.lec.ch10.service.BListService;
import com.lec.ch10.service.BModifyReplyViewService;
import com.lec.ch10.service.BModifyService;
import com.lec.ch10.service.BReplyService;
import com.lec.ch10.service.BWriteService;

// board (list.do / content.do / 
// write.do (get/post) / modify.do / delete.do / reply.do)
@Controller
@RequestMapping("board") // 공통요청경로
public class BoardController {
	@Autowired
	private BListService bListService;
	@Autowired
	private BWriteService bWriteService;
	@Autowired
	private BContentService bContentService;
	@Autowired
	private BModifyReplyViewService bModifyReplyViewService;
	@Autowired
	private BModifyService bModifyService;
	@Autowired
	private BDeleteService bDeleteService;
	@Autowired
	private BReplyService bReplyService;
	
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		//게시판의 경우 pageNum이 들어올 수 있다. (물론 들어오지 않을 수도 있음)
		model.addAttribute("pageNum", pageNum);
		bListService.execute(model);
		return "board/list";
	}
	
	// write.jsp로 가서 글작성 페이지 출력. 이후 post에서는 실제로 글쓴 내용을 service 처리
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)	
	public String write(@ModelAttribute("boardDto") BoardmvcDto boardmvcDto, Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		bWriteService.execute(model);
		return "forward:list.do";		
	}
	// list.jsp에서는 content.do?bid=4&pageNum=1 등으로 받으므로 두 개를 받아줘야
	// 글 수정 완료 후 content.do로 올 때는 after=u 패러미터가 추가되고, 이 때는 조회수가 오르지 않음.
	@RequestMapping(value = "content", method = {RequestMethod.GET, RequestMethod.POST})
	public String content(int bid, String after, Model model) {
		// 받은 패러미터 두개 + service에 데이터 보내기용으로 model
		model.addAttribute("bid", bid);
		model.addAttribute("after", after); // null이거나 u이거나
		bContentService.execute(model);
		return "board/content";		
	}
	
	// 수정하는 페이지 보여주기
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify(int bid, Model model) {
		model.addAttribute("bid", bid);
		bModifyReplyViewService.execute(model);
		return "board/modify";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("boardDto") BoardmvcDto boardmvcDto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		// 다른 값들은 이미 model에 존재함. request만 추가하여 service에 넘기면 됨.
		bModifyService.execute(model);
		return "forward:content.do?after=u";
		// 글수정후 상세보기로 가므로 after=u를 넣어서 조회수가 오르지 않도록 함.
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid); // 삭제할 글번호를 model에 대입
		bDeleteService.execute(model);
		return "forward:list.do";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(int bid, Model model) {
		model.addAttribute("bid", bid);
		bModifyReplyViewService.execute(model);
		return "board/reply";
		// 원글에 대한 정보가 board/reply로 보내진다.
	}
	
	// bgroup, bstep, bindent는 원글 / bname, btitle, bcontent는 답변글 정보.
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(@ModelAttribute("boardDto") BoardmvcDto boardmvcDto, 
			HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		// boardDto는 이미 들어가 있음.
		bReplyService.execute(model);
		return "forward:list.do";
	}

}
