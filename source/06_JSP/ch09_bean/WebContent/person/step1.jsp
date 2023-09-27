<%@page import="com.lec.ex.Person"%>
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
	Person person = new Person();
	person.setName(request.getParameter("name"));
	person.setAge(Integer.parseInt(request.getParameter("age")));
	person.setGender(request.getParameter("gender").charAt(0)); // request.getParameter는 무조건 String으로 받으므로 형변환이 필요
	person.setAddress(request.getParameter("address"));
	%>
	<h2>입력받은 개인정보 (step1)</h2>
	<p>
		이름:
		<%=person.getName()%></p>
	<p>
		나이:
		<%=person.getAge()%></p>
	<p>
		성별:
		<%=person.getGender()%></p>
	<p>
		주소:
		<%=person.getAddress()%></p>
</body>
</html>