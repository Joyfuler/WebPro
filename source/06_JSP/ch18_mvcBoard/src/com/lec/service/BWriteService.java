package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardmvcDao;

public class BWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// bname, btitle, bcontent 파라미터를 받고, bip도 가져옴.
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr(); // 127.0.0.1;
		BoardmvcDao bDao = new BoardmvcDao();
		request.setAttribute("writeResult", bDao.writeBoard(bname, btitle, bcontent, bip));
		// result, dto등 변수 작업을 빼고 즉시 result를 넣어줌. writeBoard의 경우 반환값은 어차피 int 1 아니면 에러이므로

	}

}
