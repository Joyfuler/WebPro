package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.lec.ch17.util.Paging;
import com.lec.ch17.vo.Board;

public interface BoardService {
	public List<Board> boardList(Paging paging);
	public int getBoardTotCnt();
	public int boardWrite(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request);
	public Board boardContent(int bid, String after);
	public Board boardModifyReplyView(int bid);
	public int boardModify (MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request);
	public int boardDelete(int bid);
	public int boardReply(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request);
	public void dummyData70Write();	
}