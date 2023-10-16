package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class LoginServce implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.midConfirm(mid);
		if (result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			MemberDto sessionMember = mDao.getMember(mid);
			session.setAttribute("member", sessionMember);
			request.setAttribute("loginResult", "로그인성공");
		} else if (result == MemberDao.FAIL) {
			request.setAttribute("loginErrorMsg", "로그인실패. 아이디 or 비밀번호 확인");
		}
	}
}
