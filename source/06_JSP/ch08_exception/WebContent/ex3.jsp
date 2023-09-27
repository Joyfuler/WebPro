<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<%@ page errorPage="/error/error500.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/이름을변경하세요.css" rel="stylesheet"
	type="text/css"
>
</head>
<body>
	<a href="x.jsp">없는 파일로 가라고 하면 404에러</a>
	<%
		String nullStr = request.getParameter("xx").toLowerCase(); // NullPointerException발생.
	%>
</body>
</html>