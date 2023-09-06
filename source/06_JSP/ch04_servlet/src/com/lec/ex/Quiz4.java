package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz4
 */
@WebServlet("/Quiz4")
public class Quiz4 extends HttpServlet {
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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwOut = "";
		for (int idx=0; idx<pw.length(); idx++) {
		pwOut += "*";
		}
		String pwChk = request.getParameter("pwChk");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		if (gender.equalsIgnoreCase("f")) {
			gender = "여자";
		} else {
			gender = "남자";
		}
		String email = request.getParameter("email");
		String getMail = request.getParameter("getmail");
		PrintWriter out = response.getWriter();
		out.println("<h2>회원가입정보</h2>");
		out.println("이름 : " + name + "<br>");
		out.println("아이디 : " + id + "<br>"); 
		out.println("비번 : " + pwOut + "<br>");
		out.println("생년월일 : " + birth + "<br>");
		out.println("취미 : " + Arrays.toString(hobby) + "<br>");		
		out.println("성별 : " + gender + "<br>");
		out.println("이메일 : " + email + "<br>");
		out.println("수신할 이메일 : " + getMail + "<br>");		
		
	}

}
