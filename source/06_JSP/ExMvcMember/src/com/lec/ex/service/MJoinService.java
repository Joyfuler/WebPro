package com.lec.ex.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MvcMemberDao;
import com.lec.ex.dto.MvcMemberDto;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mbirthStr = request.getParameter("mbirth");
		Date mbirth = null;
		if (mbirthStr != null && !mbirthStr.equals("")) {
			mbirth = Date.valueOf(mbirthStr);
		}
		MvcMemberDto joinMemberDto = new MvcMemberDto(mid, mpw, mname, memail, mbirth, null);
		MvcMemberDao mDao = MvcMemberDao.getInstance();
		int result = mDao.idConfirm(mid);
		if (result == MvcMemberDao.EXIST) {
			request.setAttribute("joinResult", "이미 존재하는 아이디입니다.");
			return;
		} else {
			result = mDao.joinMember(joinMemberDto);
			if (result == MvcMemberDao.SUCCESS) {
				request.setAttribute("joinResult", "회원가입완료");
				HttpSession session = request.getSession();
				session.setAttribute("member", joinMemberDto);
			} else {
				request.setAttribute("joinResult", "회원가입 정보 길이 확인");
			}
		}				
	}

}
