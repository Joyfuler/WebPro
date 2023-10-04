<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath}/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<c:set var = "nowDate" value = "<%=new Date(System.currentTimeMillis())%>"></c:set>
	<c:set var = "nowTimestamp" value = "<%=new Timestamp(System.currentTimeMillis())%>"></c:set>
	<c:set var = "nowDateUtil" value = "<%=new java.util.Date()%>"/>
	${nowDate } <br>
	${nowTimestamp } <br>
	${nowDateUtil } <br>
	<hr>
	<h4> 날짜만 출력 (short,medium, long, full)</h4>
	short: <fmt:formatDate value="${nowDate }" type = "date" dateStyle="short"/><br>
	short: <fmt:formatDate value="${nowTimestamp }" type = "date" dateStyle="short"/><br>
	short: <fmt:formatDate value="${nowDateUtil }" type = "date" dateStyle="short"/><br>
	medium: <fmt:formatDate value="${nowDateUtil }" type = "date" dateStyle="medium"/><br>
	long: <fmt:formatDate value="${nowDateUtil }" type = "date" dateStyle="long"/><br>
	full: <fmt:formatDate value="${nowDateUtil }" type = "date" dateStyle="full"/><br>
	<hr>
	<h4> 시간만 출력 (short,medium, long, full or pattern)</h4>
	short: <fmt:formatDate value="${nowDate }" type = "time" timeStyle = "short"/><br>
	medium: <fmt:formatDate value="${nowDate }" type = "time" timeStyle = "medium"/><br>
	long: <fmt:formatDate value="${nowDate }" type = "time" timeStyle = "long"/><br>
	full: <fmt:formatDate value="${nowDate }" type = "time" timeStyle = "full"/><br>
	<hr>
	<h4> 시간/ 날짜 모두 출력</h4>
	<fmt:formatDate value="${nowTimestamp }" type = "both" dateStyle="long" timeStyle="short"/><br>
	<fmt:formatDate value="${nowDate }" type = "both" pattern = "yyyy년 MM월 dd일 (E요일) a hh:mm:ss"/><br>
</body>
</html>