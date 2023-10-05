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
	<c:set var = "SUCCESS" value = "1"/>
	<c:set var = "FAIL" value = "0"/>
	<c:if test="${joinResult eq SUCCESS }">
	<script>
	alert('회원가입성공');
	</script>
	</c:if>
	<c:if test="${joinResult eq FAIL }">
	<script>
	alert('회원가입실패');
	history.back();
	</script>
	</c:if>
	<table>
		<tr><th>순번</th><th>ID</th><th>PW</th><th>이름</th><th>생일</th><th>가입</th></tr>
		<c:if test="${lists.isEmpty() }">
			<tr><td colspan="6"> 가입한 회원이 없습니다. </td></tr>
		</c:if>
		<c:if test="${!lists.isEmpty() }">
			<c:set var = "idx" value = "1"/>
			<c:forEach var="list" items="${lists }">
			<tr>
				<td>${idx }</td>
				<td>${list.id }</td>
				<td>${list.pw }</td>
				<td>${list.name }</td>
				<td>${list.birth }</td>
				<td>${list.rdate }</td>
			<c:set var = "idx" value = "${idx +1 }"/>		
			</c:forEach>
		</c:if>
	</table>
</body>
</html>