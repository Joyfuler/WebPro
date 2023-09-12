<%@page import="sun.java2d.pipe.SpanShapeRenderer.Simple"%>
<%@page import="com.sun.javafx.collections.NonIterableChange.SimpleAddChange"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
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
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일");
	String strNow = sdf.format(now);
	
	%>
	
	<p> strNow : <%=strNow%>
	<%@include file = "1_hello.jsp" %>
	<!--  %@지시자. 다른 곳의 파일을 불러올 수 있음. include file -->
</body>
</html>