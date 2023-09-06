package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz2
 */
@WebServlet("/Quiz2")
public class Quiz2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String numStr = request.getParameter("number");
		int result = 0;
		int num = Integer.parseInt(numStr);
		PrintWriter out = response.getWriter();
		out.println ("<html>");
		out.println ("<head>");
		out.println ("<style>");
		out.println("<link href='css/quiz2.css' rel='stylesheet'>");		
		out.println ("</style>");
		out.println ("</head>");
		out.println ("<body>");		
		for (int i=0; i<=num; i++) {
			result += i;
		}
		out.println ("<h2> 1부터 " + num + "까지의 합은 " + result + "입니다</h2>");
		out.println ("</body>");
		out.println ("</html>");		
		
	}
	
}
