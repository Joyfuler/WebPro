<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<jsp:useBean id="student" class = "com.lec.quiz.Student" scope = "request"/>
<jsp:setProperty property="*" name="student"/>
<jsp:forward page="studentResult.jsp"/>
</body>
</html>