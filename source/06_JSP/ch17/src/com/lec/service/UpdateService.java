package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//update 로직 (패러미터를 받아 dao를 통해 update하기)
		System.out.println("update로직 (패러미터를 받아 dao를 통해 update하기");
		request.setAttribute("updateResult", "삭제실패"); //실패
	}

}
