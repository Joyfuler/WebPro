package com.lec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardmvcDao;
import com.lec.service.Service;

public class BModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();		
		BoardmvcDao bDao = new BoardmvcDao();
		int modifyResult = bDao.updateBoard(bid, bname, btitle, bcontent, bip);
		request.setAttribute("modifyResult", modifyResult);
	}

}
