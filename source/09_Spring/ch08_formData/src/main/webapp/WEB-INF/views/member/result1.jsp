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
	<h2> 어떤 요청이든 cnt, list</h2>
	${cnt } <br>
	${list } <br>
	${name } / ${id } / ${pw } / ${age } / ${email } / ${address }
	<button onclick = "history.back()">뒤로가기</button>
	<button onclick = "location.href='${conPath}'">다시입력</button>
</body>
</html>