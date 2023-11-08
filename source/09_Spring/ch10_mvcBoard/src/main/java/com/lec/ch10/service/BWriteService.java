package com.lec.ch10.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.daovo.BoardmvcDao;
import com.lec.ch10.daovo.BoardmvcDto;

@Service
public class BWriteService implements BService {
	@Autowired
	private BoardmvcDao boardDao;
	@Override
	public void execute(Model model) {
		// model에는 현재 request와 boardDto가 존재함.
		// model에 있는 것을 map으로 뺀다.
		Map<String, Object> map = model.asMap();
		BoardmvcDto boardDto = (BoardmvcDto) map.get("boardDto");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		boardDto.setBip(request.getRemoteAddr()); // ip 세팅완료
		model.addAttribute("writeResult", boardDao.writeBoard(boardDto));		
	}
	
}
