package com.lec.ch10.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.daovo.BoardmvcDao;
import com.lec.ch10.daovo.BoardmvcDto;

@Service
public class BReplyService implements BService {

	@Autowired
	private BoardmvcDao boardDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BoardmvcDto boardDto = (BoardmvcDto) map.get("boardDto");
		boardDto.setBip(request.getRemoteAddr());
		model.addAttribute("replyResult", boardDao.replyBoard(boardDto));			
		}
}
