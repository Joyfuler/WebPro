<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		// id, -pw를 패러미터로 받은 후 -> 유효한 id와 pw인 경우 로그인 처리(세션추가)
	// 유효하지 않은 경우에는 id나 pw인 경우에는 로그인처리를 하지 않고 login.jsp?msg = idcheck or pwcheck
	// welcome.jsp , login.jsp로 이동
	// request.setCharacterEncoding("utf-8");
	String msg = "";
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if (id != null && id.equals("aaa")) {
		//유효한 아이디인 경우 (빈값x,aaa와 일치)
		if (pw != null && pw.equals("111")) { // 빈칸일 경우를 대비하여 항상 != null 을 붙여줄 것
			// 비밀번호도 유효한 경우, 세션에 추가(로그인)
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
			response.sendRedirect(conPath + "/lect2_login/welcome.jsp");
		} else { // 비밀번호를 잘못 입력한 경우
			msg = URLEncoder.encode("pw를 체크하세요", "utf-8");
			response.sendRedirect(conPath + "/lect2_login/login.jsp?msg=" + msg);
			// 나중에는 회원정보를 객체로 만들어 한번에 추가할 수도 있음.
			// Member member = new Member(id,pw,"홍길동");
			// session.setAttribute("member",member);
		}

	} else { //유효하지 않은 아이디인 경우
		msg = URLEncoder.encode("id를 체크하세요", "utf-8"); // 한글메시지는 그냥 넣으면 깨지므로 URLEncoder 사용
		response.sendRedirect(conPath + "/lect2_login/login.jsp?msg=" + msg);

	}
	%>
</body>
</html>