package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MLogoutService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate(); // 로그아웃 처리
		request.setAttribute("logoutMsg", "로그아웃 되었습니다.");
		// session.remove("member") 등으로도 가능. 그러나 로그인 외에도 회원가입 정보 등이 담길 수 있으니 session.invalidate() 추천.		
	}
}
