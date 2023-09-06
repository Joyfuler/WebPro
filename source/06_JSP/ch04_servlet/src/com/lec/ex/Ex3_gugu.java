package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3_gugu
 */
@WebServlet("/Ex3")
public class Ex3_gugu extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selected = request.getParameterValues("num");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println ("<html>");
		out.println ("<body>");
		if (selected != null) {
		for (int i=0; i<selected.length; i++) {
			out.println ("<h2>"+ selected[i] + "단</h2>");
			int numSel = Integer.parseInt(selected[i]);
			for (int j=1; j<10; j++) {
			out.println(selected[i] + "*" + j + "=" + (numSel*j)+ "<br>");
				}
			}		
		} else {
			out.println("<h2> 선택된 구구단이 없습니다.</h2>");
		}
		out.println ("</body>");
		out.println ("</html>");	
		out.close();
	}
	
	
}
