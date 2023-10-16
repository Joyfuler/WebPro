package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class withdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = null;
		MemberDto sessionMember = (MemberDto) session.getAttribute("member");
		if (sessionMember != null) { // 로그인을 한 경우
			mid = sessionMember.getMid();
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.withdrawalMember(mid); // 회원탈퇴. 만일 회원정보가 없다면 null을 delete하면서 0행 삭제됨.
		if (result == MemberDao.SUCCESS) {
			request.setAttribute("withdrawalResult", "회원탈퇴가 완료되었습니다.");
			session.invalidate();
		} else {
			request.setAttribute("withdrawalResult", "로그인되어있지 않습니다");
		}
	}

}
