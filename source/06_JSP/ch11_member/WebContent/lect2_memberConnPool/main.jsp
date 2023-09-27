<%@page import="com.lec.member.MemberDto"%>
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
		// 로그인했을 때 session을 추가함.
	MemberDto member = (MemberDto) session.getAttribute("member");
	// object 리턴이므로, 앞과 동일하게 형변환.
	if (member != null) { // 로그인하여 세션이 있는 상태
		out.print("<h3>" + member.getName() + " (" + member.getId() + ") 님 어서오세요.</h3> ");
		out.print("<p>");
		out.print("<button onclick = 'location.href = \"modify.jsp\"'> 정보수정 </button> ");
		out.print("<button onclick = 'location.href = \"logout.jsp\"'> 로그아웃 </button> ");
		out.print("</p>");
	} else { // 로그인 x, 세션이 없는 상태라면
		out.print("<h3> 손님, 어서오세요. </h3>");
		out.print("<p>");
		out.print("<button onclick = 'location.href = \"join.jsp\"'> 회원가입 </button> ");
		out.print("<button onclick = 'location.href = \"login.jsp\"'> 로그인 </button> ");
		out.print("<button onclick = 'location.href = \"modify.jsp\"'> 정보수정 </button> ");
		out.print("</p>");
	}
	%>
</body>
</html>