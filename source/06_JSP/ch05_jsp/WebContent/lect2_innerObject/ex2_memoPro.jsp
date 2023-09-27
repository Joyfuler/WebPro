<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String memo = request.getParameter("memo");
	String ip = request.getRemoteAddr();
	Date date = new Date(System.currentTimeMillis()); //요청한 시점
	Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	%>

	<h2>
		글쓴이 :
		<%=writer%></h2>
	<h2>
		글내용 :
		<%=memo%></h2>
	<h2>
		ip :
		<%=ip%></h2>
	<h2>
		작성일 :
		<%=currentTime%></h2>
</body>
</html>