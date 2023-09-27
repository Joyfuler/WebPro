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
	<jsp:useBean id="student" class="com.lec.quiz.Student" scope="request" />
	<h2>입력하신 결과는 다음과 같습니다</h2>
	학번:
	<jsp:getProperty name="student" property="studentNum" /><br> 이름:
	<jsp:getProperty name="student" property="name" />
	님
	<br> 학년:
	<jsp:getProperty name="student" property="grade" />학년
	<br> 반이름:
	<jsp:getProperty name="student" property="className" />반
	<br> 점수:
	<jsp:getProperty name="student" property="score" />점


</body>
</html>