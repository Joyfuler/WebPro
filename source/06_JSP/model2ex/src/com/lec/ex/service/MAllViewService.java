package com.lec.ex.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MAllViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum.isEmpty()) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3;
		final int BLOCKSIZE = 5;
		int startRow = (currentPage-1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE -1;
		MemberDao mDao = MemberDao.getInstance();		
		ArrayList<MemberDto> members = mDao.getMemberList(startRow, endRow);		
		request.setAttribute("members", members);	
		//view단에서의 출력을 위해서. 또한 페이징 처리를 위한 패러미터도 넘겨야 함.
		int totCnt = mDao.getMemberTotCnt();
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage -1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE -1;
		if (endPage >pageCnt) {
			endPage = pageCnt;
		}		
		request.setAttribute("PAGESIZE", PAGESIZE);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("pageNum", currentPage);		
		}
	}
	

