package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete로직, 패러미터를 받아 dao에 있는 delete 기능 수행");
		request.setAttribute("deleteResult", "삭제성공");
		
		// 예시)
		//String bid = request.getParameter("bid");
		//int result = dao.deleteBoard(bid);
		//request.setAttribute("deleteResult", result);
		// if (result ==1){
		// request.setAttribute("deleteResult", "삭제성공");~
	}

}
