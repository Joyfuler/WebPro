package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MvcMemberDao;
import com.lec.ex.dto.MvcMemberDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MvcMemberDao mDao = MvcMemberDao.getInstance();
		int result = mDao.loginCheck(mid, mpw);
		if (result == MvcMemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			MvcMemberDto sessionMember = mDao.getMember(mid);
			session.setAttribute("member", sessionMember);
			request.setAttribute("loginResult", "로그인성공");			
		} else if (result == MvcMemberDao.FAIL){
			request.setAttribute("loginResult", "로그인실패. 아이디 or 비밀번호 확인");
		}
	}
}
