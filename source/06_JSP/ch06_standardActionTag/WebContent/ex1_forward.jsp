<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  요청 url : ex1_forward.jsp?n=1. 패러미터는 n=1로 -->
	<h2> ex1_forward.jsp 입니다</h2>
	<%
	// response.sendRedirect("ex2_forward.jsp"); //주소창의 url이 변경됨. -> 새로운 request 요청
	%>
	<!-- 위와같이 request를 하더라도 ex2_forward에서 n=1이 증발함. -->
	<jsp:forward page="ex2_forward.jsp"/> <!--  닫는 태그는 jsp/ react에서만! -->
</body>
</html>