<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:if test = "${not empty loginErrorMsg }">
	<!--  만일 에러가 발생해 메인으로 온 상황이라면 -->
	<script>
	alert('${loginErrorMsg}');
	location.href='${conPath }/loginView.do';
	</script>
	</c:if>
	<c:if test = "${not empty modifyResult }">
	<script>
	alert('${modifyResult }');
	</script>
	</c:if>
	<c:if test = "${not empty modifyErrorMsg }">
	<script>
	alert('${modifyErrorMsg }');
	history.back();	
	</script>
	</c:if>
	<c:if test = "${not empty withdrawalResult }">
	<script>
	alert('${withdrawalResult }');	
	</script>
	</c:if>
	
	<c:if test="${empty member }">
		<!-- sessionScope, requestScope등을 생략할 수 있음. 로그인하지 않은 경우 -->
		<h1> 로그인 상태가 아닙니다.</h1>
		<hr>
		<p>
		<!--  요청은 반드시 .do로 설정하자. -->
			<button onclick = "location.href='${conPath}/loginView.do'">로그인</button>
			<button onclick = "location.href='${conPath}/joinView.do'">회원가입</button>
			<button onclick = "location.href='${conPath}/allView.do'">전체회원보기</button>			
		</p>	
	</c:if>
	<c:if test="${not empty member }">
		<!-- 로그인 이후 화면 -->
			<h1> ${member.mname }(${member.mid}) 님 어서오세요</h1>
		<hr>
		<p>
		<!--  요청은 반드시 .do로 설정하자. -->
			<button onclick = "location.href='${conPath}/logout.do'">로그아웃</button>
			<button onclick = "location.href='${conPath}/modifyView.do'">정보수정</button>
			<button onclick = "location.href='${conPath}/allView.do'">전체회원보기</button>			
		</p>	
	</c:if>	
</body>
</html>