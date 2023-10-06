package com.lec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardmvcDao;
import com.lec.service.Service;

public class BModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// bid 패러미터를 받아 dao를 통해 dto를 request에 setAttribute
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardmvcDao bDao = new BoardmvcDao();
		request.setAttribute("modifyBoard", bDao.getBoardInfo(bid));
	}

}
