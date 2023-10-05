package ch18_mvcpractice.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch18_mvcpractice.MemberDao;
import ch18_mvcpractice.MemberDto;

public class MemberJoinService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthStr = request.getParameter("birth");// ""나 "1999-12-12"
		Date birth = null;
		if (!birthStr.contentEquals("")) {
			birth = Date.valueOf(birthStr);
		}
		MemberDto newMember = new MemberDto(id, pw, name, birth, null);
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.joinMember(newMember);
		if (result == MemberDao.SUCCESS) {
			request.setAttribute("joinResult", result);
		} else {
			request.setAttribute("joinResult", result);
		}
		
		
	}

}
