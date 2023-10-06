package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardmvcDao;

public class BReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 답변글의 정보를 가져옴.
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr(); // ip는 parameter가 아니라 직접 주소를 가져와야.
		// 원글의 정보도 가져와서, dao에서 +1을 해야함.
		int bgroup = Integer.parseInt(request.getParameter("bgroup"));
		int bstep = Integer.parseInt(request.getParameter("bstep"));
		int bindent = Integer.parseInt(request.getParameter("bindent"));
		BoardmvcDao bDao = new BoardmvcDao();
		request.setAttribute("replyResult", bDao.replyBoard(bname, btitle, bcontent, bip, bgroup, bstep, bindent));
		
	}

}
