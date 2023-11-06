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
	<h3> Board의 list.jsp 페이지입니다.</h3>
	<c:if test = "${list.size() eq 0}">
		출력할 데이터가 없습니다.
	</c:if>
	<c:if test = "${list.size() != 0 }">
	<c:forEach var="member" items="${list }">
	<h4> ID : ${member.id } / PW: ${member.pw } </h4>
	</c:forEach>		
	<h4> 이상 추가된 member는 ${list.size()} 명입니다</h4>
	</c:if>
	<hr>
	<h4 onclick = "history.go(-1)">이전 페이지로 가기</h4>
</body>
</html>