package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz3
 */
@WebServlet("/Quiz3")
public class Quiz3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String title = request.getParameter("title");
		String name = request.getParameter("writer");
		String desc = request.getParameter("desc");		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<header>");		
		out.println("<link href='css/Quiz3.css' rel='stylesheet'>");		
		out.println("</header>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th colspan='2'>");
		out.println("<h2>반갑습니다," + name + "님");
		out.println("</th>");
		out.println("<tr>");
		out.println("<th> 글제목 </th>");		
		out.println("<td>" + title + "</td></tr>");
		out.println("<tr><th>글내용</th><td><pre>"+desc+"</pre></td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
		
	

}
