package com.lec.ch11.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch11.daovo.BoardmvcDao;

@Service
public class BListService implements BService {
	@Autowired
	private BoardmvcDao bDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // model을 map으로 변경.
		String pageNum = (String) map.get("pageNum");
		if (pageNum == null) {
			pageNum = "1";			
		}
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE -1;		
		model.addAttribute("boardList", bDao.listBoard(startRow, endRow));
		int orderNum = startRow; // 첫 라인에 출력할 순차번호
		int totCnt = bDao.BoardtotCount();
		int inverseNum = totCnt - startRow + 1; // 첫라인 출력 역순번호
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("inverseNum", inverseNum);
		int pageCnt = (int)Math.ceil((double)totCnt / PAGESIZE);
		int startPage = currentPage - (currentPage -1) % BLOCKSIZE;
		int endPage = startPage + BLOCKSIZE -1;
		if (endPage > pageCnt) {
			endPage = pageCnt; 
		}
		// view에 출력될 page 관련 변수들 모두 attribute로 넣기
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		// 첫 페이지 전에 더 페이지가 있는지를 확인용 
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("pageNum", pageNum);		
		// 마지막 페이지 조정용
		
		
	}

}
