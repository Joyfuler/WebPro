package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2Param
 */
@WebServlet("/Ex2")
public class Ex2Param extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 리퀘스트의 parameter 한글 처리
		doGet(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// menu, rest 패러미터'들', nation 패러미터를 전달받아 화면에 출력
		String menu = request.getParameter("menu");
		String rest = request.getParameter("restaurant");
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>선택한 메뉴는 : "+ menu + "<h2>");
		out.println("<h2>선택한 식당은 : "+ rest + "<h2>");
		out.println("<h2>선택한 국적은 : "+ nation + "<h2>");			
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}
}
