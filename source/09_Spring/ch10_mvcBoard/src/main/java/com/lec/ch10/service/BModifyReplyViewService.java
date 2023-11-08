package com.lec.ch10.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.daovo.BoardmvcDao;
@Service
public class BModifyReplyViewService implements BService {

	@Autowired
	private BoardmvcDao boardDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer) map.get("bid");
		model.addAttribute("board", boardDao.getBoardInfo(bid));
	}
}
