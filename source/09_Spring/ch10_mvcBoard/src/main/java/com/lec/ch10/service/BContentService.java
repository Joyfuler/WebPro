package com.lec.ch10.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.daovo.BoardmvcDao;
@Service
public class BContentService implements BService{
	@Autowired
	private BoardmvcDao boardDao;
	@Override
	public void execute(Model model) {
		// request 객체도 add할 수 있고, String 변수도 add할 수 있으므로
		Map<String, Object> map = model.asMap();
		int bid = (Integer) map.get("bid");
		String after = (String) map.get("after");
		if (after == null) {
			boardDao.hitup(bid); // 수정하지 않았다면 (게시글목록에서 클릭시) 조회수up
		}
		model.addAttribute("contentBoard", boardDao.getBoardInfo(bid));
		// boardDto가 contentBoard에 담겨서 전달됨.
	}

}
