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
	<c:set var = "num" value = "${param.visitNum }"/>
	<c:choose>
		<c:when test = "${num>1 && num<6 }">
		<h2> 많이 방문해주세요</h2>
		</c:when>
		<c:when test = "${num >=6 }">
		<h2> 많이 방문해주셔서 감사합니다</h2>
		</c:when>
		<c:otherwise> <%--디폴트에 해당 --%>
		제대로 된 방문횟수를 받지 못했습니다.
		</c:otherwise>
	</c:choose>	
</body>
</html>