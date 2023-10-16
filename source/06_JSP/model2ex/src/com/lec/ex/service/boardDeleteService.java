package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class boardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String fidStr = request.getParameter("fid");
		int fid = Integer.parseInt(fidStr);
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.deleteBoard(fid);
		if (result == BoardDao.SUCCESS) {
			request.setAttribute("boardResult", "삭제성공");
		} else {
			request.setAttribute("boardResult", "삭제실패");
		}

	}

}
