package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardmvcDao;

public class BContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//bid 패러미터를 받아, dto를 request에 실어서 보냄.
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardmvcDao bDao = new BoardmvcDao();
		//list.jsp를 통해 content.do로 오는 경우 조회수 +1
		// 이 때의 url은 content.do?bid=2&pageNum=2
		if (request.getParameter("after") == null) {
			bDao.hitup(bid);
		}
		request.setAttribute("contentBoard", bDao.getBoardInfo(bid));
		//수정 성공 후 content.do로 오는 경우에는 조회수가 오르지 않음.

	}

}
