package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// ex/ex3_gugu.jsp
// Ex3
@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String numStr = request.getParameter("num");
		response.setContentType("text/html; charset=utf-8");		
		int num = Integer.parseInt(numStr);		
		PrintWriter out = response.getWriter();		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("입력하신 구구단 결과는 다음과 같습니다. <br>");
		for (int i =1; i<10; i++) {			
		out.println(num + "*" + i + "=" + (num *i) + "<br>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
