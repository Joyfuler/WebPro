package com.lec.ch16.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch16.repository.BoardDao;
import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;	
	
	@Override
	public List<Board> boardList(Paging paging) {
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}

	@Override
	public int getBoardTotCnt() {
		return boardDao.getBoardTotCnt();
	}

	@Override
	public int boardWrite(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardDao.boardWrite(board);
	}

	@Override
	public Board boardContent(int bid, String after) {
		if (after == null) {
			boardDao.boardHitUp(bid);
		}
		return boardDao.getBoardDto(bid);
	}

	@Override
	public Board boardModifyReplyView(int bid) {
		return boardDao.getBoardDto(bid);
	}

	@Override
	public int boardModify(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardDao.boardModify(board);
	}

	@Override
	public int boardDelete(int bid) {
		return boardDao.boardDelete(bid);
	}

	@Override
	public int boardReply(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardDao.boardReply(board);
	}

	@Override
	public void dummyData70Write() {
		Board board = new Board();
		for (int i = 1; i < 70; i++) {
			board.setBname("홍길동"+i);
			board.setBtitle("제목"+i);
			board.setBip("192.168.1."+i);
			int result = boardDao.boardWrite(board);
			System.out.println(result ==1? i+"번째 글 작성완료": i+"번째 글 작성실패");
		}
	}
}