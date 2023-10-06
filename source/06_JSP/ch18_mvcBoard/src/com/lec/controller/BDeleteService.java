package com.lec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardmvcDao;
import com.lec.service.Service;

public class BDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		// 원글의 bid정보를 받아 해당 글번호를 삭제
		BoardmvcDao bDao = new BoardmvcDao();
		int result = bDao.deleteBoard(bid);
		String deleteMsg = (result == BoardmvcDao.SUCCESS? bid+"번 글 삭제완료" : bid+"번 글 삭제 실패");
		//이후 view단에 msg를 alert로 출력할 예정.
		request.setAttribute("deleteMsg", deleteMsg);
	}

}
