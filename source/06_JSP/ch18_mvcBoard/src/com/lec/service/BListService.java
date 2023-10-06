package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardmvcDao;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1"; //받은 pageNum이 없다면 default로 1페이지로 만듬.
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10; // 페이지 별 게시글 갯수
		final int BLOCKSIZE = 10; // 페이지 번호 갯수
		int startRow = (currentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		BoardmvcDao bDao = new BoardmvcDao();
		request.setAttribute("list", bDao.listBoard(startRow, endRow)); // 글목록페이지로 전달
		int totCnt = bDao.BoardtotCount(); // 총 게시글 갯수를 알아야 페이지 수를 측정 가능하므로
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1) / BLOCKSIZE) * BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE -1;
		if (endPage > pageCnt) { // 총 15페이지밖에 없는데 20페이지를 표시 x, 15페이지까지만 표시하게
			endPage = pageCnt;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // '이전' 을 출력할지를 확인 필요 (startPage가 BLOCKSIZE보다 크다면)
		request.setAttribute("startPage", startPage); // 시작과 마지막 페이지도 전달.
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage); // 현재 페이지에서 a태그를 빼는 용도로 사용.
		request.setAttribute("pageCnt", pageCnt); // '다음을 출력할지 확인 필요 (endPage가 pageCnt보다 작다면)
	}

}
