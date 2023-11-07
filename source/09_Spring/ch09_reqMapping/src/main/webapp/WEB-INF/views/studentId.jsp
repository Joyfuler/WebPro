<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/style.css" rel = "stylesheet">
</head>
<body>
	<h2> StudentId.jsp 페이지</h2>
	<h2> 입력한 아이디 : ${id }</h2>
	<h2> 패러미터 id : ${param.id }</h2>
	<h2> submit시의 method : ${method }</h2>	
</body>
</html>