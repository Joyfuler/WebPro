package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.AdminDao;
import com.lec.ex.dto.AdminDto;

public class AdminLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao aDao = AdminDao.getInstance();
		int result = aDao.adminLoginChk(aid, apw); // 로그인체크
		if (result == AdminDao.SUCCESS) {
			AdminDto admin = aDao.getAdmindto(aid);
			request.setAttribute("adminLoginResult", "admin 로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);			
		} else {
			request.setAttribute("adminLoginErrorMsg", "admin 로그인 실패");
		}
	}

}
