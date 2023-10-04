<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<%--String conPath = request.getContextPath();--%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<h2> 변수 선언 및 출력, 삭제</h2>
	<c:set var = "varName" value = "varValue" scope = "page"></c:set>
	varName: ${varName }<br>
	<c:set var = "varName" value = "varValue <varValue>"/>
	varName: ${varName }(수정후)<br> <!-- value 안에 <> 가 있으므로 정상적으로 출력되지 않으므로 출력용인 c:out을 대신 사용 -->
	varName: <c:out value = "${varName }"/><br>
	<c:remove var = "varName"/> <!-- varName변수 삭제 -->
	varName : ${varName }<br>
	varName : ${empty varName ? "변수없음": varName }
	varName : <c:out value = "${varName }" default = "변수없음"/>	
</body>
</html>