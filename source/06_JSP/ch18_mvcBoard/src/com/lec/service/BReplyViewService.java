package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardmvcDao;

public class BReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		// 원글의 bid정보를 통해 dto를 가져와야 함.
		BoardmvcDao bDao = new BoardmvcDao();
		request.setAttribute("replyBoard", bDao.getBoardInfo(bid));
		//원글의 정보가져다가 전달함.
	}
}