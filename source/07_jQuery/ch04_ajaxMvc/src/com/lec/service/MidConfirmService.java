package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.daodto.MemberDao;

public class MidConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String mid = request.getParameter("mid");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.midConfirm(mid);
		if(result == MemberDao.EXIST){
			request.setAttribute("confirmResult","<b>�ߺ��� ID�Դϴ�</b>");
		}else{
			request.setAttribute("confirmResult","��� ������ ID�Դϴ�");
		}
	}

}
