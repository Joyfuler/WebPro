<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<h3> 받은이름: ${param.name }</h3> 
	<h3> 받은아이디: ${param.id }</h3>
	<h3> 받은비번: ${param.pw }</h3>
</body>
</html>