package com.lec.ch15.util;

import lombok.Data;

@Data
public class Paging {
	private int currentPage = 1; // 기본은 1페이지
	private int pageSize;
	private int blockSize;
	private int startRow;
	private int endRow;
	private int totCnt;
	private int pageCnt;
	private int startPage;
	private int endPage;	
	// empList.do 또는 empList.do?pageNum = 2
	// Paging paging = new Paging(총 게시글 수, 파라미터로 받은 pageNum은 null이거나 숫자, 페이지사이즈, 블록사이즈)
	public Paging(int totCnt, String pageNum, int pageSize, int blockSize) {
		this.totCnt = totCnt; // 매개변수로 온 totCnt를 생성자로 대입
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}		
		this.pageSize = pageSize;
		this.blockSize= blockSize;
		startRow = (currentPage-1) * pageSize + 1;
		endRow = startRow + pageSize -1;
		pageCnt = (int) Math.ceil((double)totCnt / pageSize);
		// startPage = ((currentPage-1) / blockSize) * blockSize + 1;
		startPage = currentPage - (currentPage-1) % blockSize;
		endPage = startPage + blockSize -1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		
		
	}
}
