package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch17.service.BoardService;
import com.lec.ch17.util.Paging;
import com.lec.ch17.vo.Board;

@Controller
public class BoardController {
	@Autowired
	public BoardService boardService;	
	
	@RequestMapping(value = "boardList", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardList(String pageNum, Model model) {
		Paging paging = new Paging(boardService.getBoardTotCnt(), pageNum, 5, 10);
		model.addAttribute("paging", paging);
		model.addAttribute("boardList", boardService.boardList(paging));
		return "board/list";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Board board, Model model, MultipartHttpServletRequest mRequest, HttpServletRequest request) {
		model.addAttribute("writeResult", boardService.boardWrite(mRequest, board, request));
		return "forward:boardList.do";		
	}
	
	@RequestMapping(value = "content", method = {RequestMethod.GET, RequestMethod.POST})
	public String content(int bid, String after, Model model) {
		model.addAttribute("contentBoard", boardService.boardContent(bid, after));
		return "board/content";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify(int bid, Model model) {
		model.addAttribute("board", boardService.boardModifyReplyView(bid));
		return "board/modify";
	}	
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(Board board, Model model, MultipartHttpServletRequest mRequest, HttpServletRequest request) {
		model.addAttribute("modifyResult", boardService.boardModify(mRequest, board, request));
		return "forward:content.do";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bid));
		return "forward:boardList.do";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(int bid, Model model) {
		model.addAttribute(boardService.boardModifyReplyView(bid));
		return "board/reply";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(Board board, Model model, MultipartHttpServletRequest mRequest, HttpServletRequest request) {
		model.addAttribute("replyResult", boardService.boardReply(mRequest, board, request));
		return "forward:boardList.do";
	}	
}
