<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!-- taglib사용시 반드시 c: 로 시작하도록 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<h1> core 라이브러리 태그: if, for, switch, 변수 선언 등을 대신함. </h1>
		<c:forEach var= "i" begin="1" end="3" step = "1">
		<!-- for(int i=1; i<=3; i++){ 과 동일 -->
			<p> ${i }번째 손님 어서오세요</p>
		</c:forEach>
	<h1> fmt 라이브러리 태그: 날짜 및 숫자 format, 다국어지원 </h1>
		<fmt:formatNumber value="1234567.256" pattern="#,###.##"/>
		<!-- 세자리마다 쉼표를 넣도록 함. -->
	<h1> 그외 라이브러리 (functions) : fn 라이브러리는 el 표기법과 함께 사용</h1>
</body>
</html>