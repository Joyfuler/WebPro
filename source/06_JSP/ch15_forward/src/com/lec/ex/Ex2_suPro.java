package com.lec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2_suPro
 */
@WebServlet("/ex2_suPro")
public class Ex2_suPro extends HttpServlet {
	private static final long serialVersionUID = 1L;       

    public Ex2_suPro() {
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
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0;
		for (int i=0; i<=su; i++) {
			sum += i;
		}
		// view 단으로 데이터 보내기
		request.setAttribute("sum", sum); //request에 sum 값 추가
		RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex2_suView.jsp");
		//forward할 객체
		dispatcher.forward(request, response);		
		
	}
}
