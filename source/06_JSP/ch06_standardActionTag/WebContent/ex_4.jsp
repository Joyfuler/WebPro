<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> ex4.jsp 페이지입니다</h1>
	<h3> ex3의 request에서 넘어온 n : <%=request.getParameter("n") %></h3>
	<% String id = request.getParameter("id");
	String pw = request.getParameter("pw");
		
	%>
	받은 아이디는 <%=id %>, 비밀번호는 <%=pw %> 입니다
</body>
</html>