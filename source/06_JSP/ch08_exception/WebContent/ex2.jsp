<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<%@ page errorPage="exceptionPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/이름을변경하세요.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	// 넘어올 때는 String이므로 Integer 형변환 꼭!
	int num2 = Integer.parseInt(request.getParameter("num2"));
	out.println("<h2> num1 = " + num1 + "</h2>");
	out.println("<h2> num2 = " + num2 + "</h2>");
	out.println("<h2> num1+ num2 = " + (num1+num2) + "</h2>");
	out.println("<h2> num1* num2 = " + (num1*num2) + "</h2>");
	out.println("<h2> num1- num2 = " + (num1-num2) + "</h2>");
	out.println("<h2> num1/ num2 = " + (num1/num2) + "</h2>");
	%>
	
</body>
</html>