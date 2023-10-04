package com.lec.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/empList")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		EmpDao eDao = EmpDao.getInstance();
		ArrayList<EmpDto> lists = eDao.getListEmp();
		request.setAttribute("lists", lists); // 출력할 데이터들을 forward하기 위해 request 객체로 넣음.
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empList.jsp"); // forward하기 위한 dispatcher 객체 준비
		dispatcher.forward(request, response); // request에 lists 객체를 담아 forward 완료. 
		
	}

	
}
