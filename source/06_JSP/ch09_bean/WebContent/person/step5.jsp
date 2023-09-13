<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<jsp:useBean id="person" class = "com.lec.ex.Person" scope = "request"/>
	<jsp:setProperty property="*" name="person"/>
	<jsp:forward page="personView.jsp"/>
</body>
</html>