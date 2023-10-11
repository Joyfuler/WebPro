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
<c:if test="${not empty loginResult }">
	<script>
	alert('${loginResult }');
	</script>
</c:if>
<c:if test = "${not empty logoutMsg }">
	<script>
	alert('${logoutMsg }');
	</script>
</c:if>	
	<h1>아무것도 없는 메인페이지입니다.</h1>
	<c:if test="${not empty member }">
	<h3>${member.mname }님 어서오세요</h3>
	</c:if>	
	<table>
		<tr>
			<td>
		<c:if test = "${not empty member }">
		<button onclick = "location.href='${conPath }/logout.do'">로그아웃</button>	
		</c:if>
		<c:if test = "${empty member }">
		<button onclick = "location.href='${conPath }/loginView.do'">로그인</button>
		<button onclick = "location.href='${conPath }/joinView.do'">회원가입</button>
		</c:if>
		</td>	
		</tr>
	</table>
</body>
</html>