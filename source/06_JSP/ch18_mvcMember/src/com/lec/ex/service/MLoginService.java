package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.mysql.cj.Session;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//받은 패러미터로 로그인 처리 후 세션 처리를 실행.
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.loginCheck(mid, mpw);
		if (result == MemberDao.SUCCESS) { //로그인 성공시 세션 가져옴.
			HttpSession session = request.getSession();
			// 기존에는 session.setAttribute가 바로 가능했으나 java에서는 불가능하므로 Httpsession을 사용해야 함.
			MemberDto member = mDao.getMember(mid);
			// session에 넣을 유저의 데이터.
			session.setAttribute("member", member);
		} else {
			request.setAttribute("loginErrorMsg", "아이디와 비밀번호를 확인하세요");
			
			
		}
	}

}
