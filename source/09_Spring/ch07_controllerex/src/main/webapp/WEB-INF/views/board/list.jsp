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
	<h3>board의 list.jsp입니다</h3>
	<c:if test="${list.size() eq 0 }">
		<h3> 추가 member 없음</h3>
	</c:if>
	<c:if test = "${list.size() != 0 }">
		<c:forEach var = "member" items="${list }">
			<h4>
				ID: ${member.id }
				PW: ${member.pw }
				총인원 ${list.size() } 명
			</h4>
		</c:forEach>
	</c:if>
	<hr>
	<h4 onclick="history.go(-1)">이전 페이지로 가기</h4>
</body>
</html>