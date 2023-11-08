package com.lec.ch10.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.daovo.BoardmvcDao;
import com.lec.ch10.daovo.BoardmvcDto;

@Service
public class BModifyService implements BService {

	@Autowired
	private BoardmvcDao boardDao;
	
	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		BoardmvcDto boardDto = (BoardmvcDto) map.get("boardDto");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		boardDto.setBip(request.getRemoteAddr());
		model.addAttribute("modifyResult", boardDao.updateBoard(boardDto));
	}
	
}
