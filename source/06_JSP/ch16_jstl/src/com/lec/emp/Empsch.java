package com.lec.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/empsch")
public class Empsch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Empsch() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//schName과 schJob 패러미터를 받아 출력.
		//이후 view단으로 forward함.
		String schName = request.getParameter("schName");
		String schJob = request.getParameter("schJob");
		EmpDao eDao = EmpDao.getInstance();
		ArrayList<EmpDto> lists = eDao.getListEmp(schName, schJob);
		request.setAttribute("lists", lists);
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/EmpSch.jsp");
		dispatcher.forward(request, response);
	}

}
