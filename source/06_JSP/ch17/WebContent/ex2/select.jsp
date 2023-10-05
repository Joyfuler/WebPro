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
	<c:if test="${insertResult eq SUCCESS }">
	<!-- frontcontroller에서 넘어온 패러미터는 insertResult와 list -->
		<script>
		alert("입력성공");
		</script>
	</c:if>
	<c:set var = "FAIL" value = "0"/>
	<c:if test="${insertResult eq FAIL }">
		<script>
		alert('입력실패');
		</script>
	</c:if>	
	<c:if test="${updateResult eq SUCCESS }">
		<script>
		alert('수정성공');
		</script>
	</c:if>
	<c:if test="${not empty updateResult && updateResult != SUCCESS }">
		<script>
		alert('수정실패');
		</script>
	</c:if>
	<c:if test="${not empty deleteResult }">
		<script>
		alert('${deleteResult}');
		</script>
	</c:if>
	<h1> select.jsp입니다.</h1>
	<h2>select 결과: ${list }</h2>
	<!--  selectService에서 setAttribute했던 앞의 명칭을 가져옴.  -->
</body>
</html>