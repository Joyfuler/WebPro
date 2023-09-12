package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet(name = "HelloWorld", urlPatterns = { "/HW" })
// 본래는 src를 그대로 웹에서 구동이 불가능하나, @Webservlet을 통해 url 맵핑을 하여 웹페이지에서 출력할 수 있게끔 해줌.
public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet호출");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo (request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 호출");
		// post 방식으로 요청하는 방법 -> submit 버튼의 method가 post인 경우에만 실행됨.
		actionDo (request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h1 { color: blue}");	
		out.println("</style>");		
		out.println("</head>");	
		out.println("<body>");
		out.println("<h1> 안녕하세요. 첫 Servlet 예제입니다.");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
	
	
}
