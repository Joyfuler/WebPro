package com.lec.ch18.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ch18.dao.MemberDao;
import com.lec.ch18.dto.MemberDto;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//Dao를 통해 member 리스트 가져오기.
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> members = mDao.listMember(); 
		request.setAttribute("members", members);

	}

}
