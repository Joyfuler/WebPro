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
	<c:set var = "n1" value = "${param.n1 }"/>
	<c:set var = "n2" value = "${param.n2 }"/>
	<c:set var = "result" value = "${param.result }"/>
	<p>
	${n1 } * ${n2 } = ${result }은
	<c:if test = "${n1*n2 eq result }">
	정답입니다
	</c:if>
	<c:if test = "${n1*n2 != result }" var = "conditionResult">
	오답입니다
	</c:if>
	<p>두 번쨰 if문에 대한 conditionResult = ${conditionResult }</p>
</body>
</html>