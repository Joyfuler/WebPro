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
	<h2>예외 처리 태그</h2>
	<c:catch var = "e"><!-- c:catch절에서 예외 발생시 예외 객체가 e변수에 할당되고 c:catch절을 빠져나감 -->
	<h2>테스트 </h2>
	${8/0 }
	</c:catch>
	예외타입과 메시지 : <c:out value = "${e }" default = "예외 발생 안됨"/>
</body>
</html>