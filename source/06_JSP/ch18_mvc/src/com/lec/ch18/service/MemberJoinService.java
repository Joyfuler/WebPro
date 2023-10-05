package com.lec.ch18.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ch18.dao.MemberDao;
import com.lec.ch18.dto.MemberDto;

public class MemberJoinService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthStr = request.getParameter("birth");
		Date birth = null;
		if (! birthStr.equals("")) { // 생일 입력한경우
			birth = Date.valueOf(birthStr);				
		}		
		// 만일 사진 등 첨부 기능이 필요하다면 request대신 multipartrequest를 사용해야함.
		MemberDto newMember = new MemberDto(id, pw, name, birth, null);
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.joinMember(newMember);
		request.setAttribute("joinResult", result); // 결과는 1 or 0
		if (result ==MemberDao.SUCCESS) {
			request.setAttribute("joinMsg", "가입성공");
		} else {
			request.setAttribute("joinMsg", "가입실패");
		}
	}
	
}
