package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String name = request.getParameter("name");
		String numStr = request.getParameter("num");
		response.setCharacterEncoding("text/html; charset=utf-8");
		if (numStr == null) {			
			response.getWriter().print("넘어온 파라미터가 없습니다.");			
		} else {
			// 누적한 결과 이름과 함께 출력
			int num = Integer.parseInt(numStr);
			int total = 0;
			for (int idx =1; idx <=num; idx++) {
				total += idx;
			}
			PrintWriter out = response.getWriter(); //스트림생성
			out.println("<html>");
			out.println("<head>");
			// 현재 위치는 /ch03_semiServlet/Ex2
			// css 위치는 /ch03_semiServlet/css/ex2.css
			out.println("<link href ='css/ex2.css' rel = 'stylesheet'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>" + name + "님이 요청하신 누적 결과는 아래와 같습니다.</h1>");
			out.println("<h2> 1부터" + num + "까지 누적합은 " + total + "입니다");
			out.println("</body>");
			out.println("<html>");
			out.close();			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);		
	}	
}
