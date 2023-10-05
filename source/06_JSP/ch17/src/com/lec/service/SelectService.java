package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 실행할 select 로직
		System.out.println("select 로직 수행함 (pageNum받아 startRow, endRow 계산, dao에서 list를 받아"
				+ "request에");
		request.setAttribute("list", "(list - 결과 arraylist로 받은 거)");
		request.setAttribute("startRow", "시작페이지");
		request.setAttribute("endRow", "종료페이지"); // 등등 넘길 데이터를 모두 setAttribute해서 넣는다.			
	}

}
