<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/error/error.css" rel = "stylesheet">
</head>
<body>
<script>
alert('${conPath}');
</script>
	<jsp:include page="${conPath }/main/header.jsp"/>	
	<h1> Page Not Found</h1>
	<h3>요청하신 페이지를 찾을 수 없습니다.</h3>
	웹 브라우저에서 새로고침하거나, 새로고침 후에도 표시되지 않는 경우
	URL를 확인해 주세요.
	<a href = "${conPath }/index.jsp">▶메인 페이지로</a>
</body>
</html>