package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1_Test
 */
@WebServlet("/Ex1")
public class Ex1_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 수행");
		actionDo(request,response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 수행");
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//name과 pw 패러미터를 받아 브라우저에 뿌리기.
		String name = request.getParameter("name"); // request 변수에 요청
		String pw = request.getParameter("pw");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2> 이름은 : "+ name + "<h2>");
		out.println("<h2> 비밀번호는 :" + pw + "<h2>");
		out.println("요청된 방식은 :" + request.getMethod()); // 어떤 메소드를 가져왔는지를 출력
		out.println("</body>");		
		out.println("</HTML>");
		out.close();		
			
		// 뿌려질 텍스트를 다시 parameter 처리.
	}
	
}
