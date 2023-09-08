package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwOut = "";
		for (int idx = 0; idx < pw.length(); idx++) {
			pwOut += "*";
		}
		String birth = request.getParameter("birth");
		Date birthDate = null; // 날짜만 필요한 경우
		birthDate = Date.valueOf(birth);
		Timestamp birthTS = null; // 날짜와 시간이 모두 필요한 경우
		birthTS = Timestamp.valueOf(birth + " 00:00:00");		
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
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/quiz4.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><td>");
		out.println("<h2>회원가입정보</h2>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("이름 : " + name + "<br>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("아이디 : " + id + "<br>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("비번 : " + pwOut + "<br>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("생년월일 : " + (birth.contentEquals("")? "-" : birth) + "<br>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("생년월일(Date) : " + (birthDate==null? "-" : birthDate) + "<br>");
		//삼항연산자를 사용하여 birthDate를 간편히표기
		out.println("생년월일(TimeStamp) : " + (birthTS==null? "-" : birthTS) + "<br>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("취미 : ");
		int cnt = 1;		
			if (hobby.length ==0) {
				out.println("취미없음");
			}
			else if (hobby.length < 2) {
				out.println(hobby[0]);
			} else {
				for (int idx =0; idx<hobby.length; idx++) {
				out.println(cnt + ". " + hobby[idx] + " ");
				cnt++;				
			}
		}
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("성별 : " + gender + "<br>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("이메일 : " + email + "<br>");
		out.println("</td></tr>");
		out.println("<tr><td>");
		out.println("수신할 이메일 : " + getMail + "<br>");
		out.println("</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
