<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if (session.getAttribute("customer")!= null){
	session.invalidate();
%>	<script>	
	alert("로그아웃 되었습니다.");
	location.href = "../main/main.jsp";
	</script>
<%}else {%>
	<script>
	alert("이미 로그아웃된 상태입니다.");
	location.href = "../main/main.jsp";
	</script>
<%}%>
</body>
</html>