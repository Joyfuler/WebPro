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
	<h2> 마찬가지로 cnt와 list가 출력됨</h2>
	${cnt } <br>
	${list } <br>
	${memberDto.id }
	${memberDto.pw }
	${memberDto.age }
	${memberDto.email }
	${memberDto.address }
</body>
</html>