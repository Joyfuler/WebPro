package ch18_mvcpractice.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch18_mvcpractice.MemberDao;
import ch18_mvcpractice.MemberDto;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> lists = mDao.listMember();
		request.setAttribute("lists", lists);
	}
}
