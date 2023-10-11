package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MAllViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//allView.do로 넘어왔거나, allView.do?pageNum =2로 넘어옴
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
		request.setAttribute("members", mDao.getMemberList(startRow, endRow));	
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
