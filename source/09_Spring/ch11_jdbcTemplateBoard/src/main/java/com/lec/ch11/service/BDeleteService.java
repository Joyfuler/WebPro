package com.lec.ch11.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch11.daovo.BoardmvcDao;
@Service
public class BDeleteService implements BService{

	@Autowired
	private BoardmvcDao boardDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer) map.get("bid");
		int result = boardDao.deleteBoard(bid);
		String deleteMsg = result == BoardmvcDao.SUCCESS? (bid+"번 글 삭제성공") : (bid+"번 글 삭제실패");
		model.addAttribute("deleteMsg", deleteMsg);
		
	}
	
}
