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
	<c:set var = "num" value = "1234567.56"/>
	<p> num : ${num }</p>
	<p> 세자리마다 쉼표넣기: <fmt:formatNumber value = "${num }" groupingUsed="true"/>
	<p> 세자리마다 쉼표 + 소숫점까지 조정 : <fmt:formatNumber value ="${num }" pattern = "#,###.###"></fmt:formatNumber>
	<p> 세자리마다 쉼표 + 소숫점까지 조정 : <fmt:formatNumber value ="${num }" pattern = "#,###.#"></fmt:formatNumber>
	<p> 세자리마다 쉼표 + 소숫점까지 조정 : <fmt:formatNumber value ="${num }" pattern = "0,000.00000"></fmt:formatNumber>	
</body>
</html>