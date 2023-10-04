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
<h1> <a href = "${conPath }/empList"> EmpList</a></h1>
<!--  Emplist.jsp (서블릿, 프로세스, url:/empList), empList.jsp(뷰) -->
<h1> <a href = "${conPath }/empsch">이름과 직책을 검색하는 Emplist (emp, job 패러미터로 받음)</a></h1>
<!--  EmpSch.java (서블릿, 프로세스, url:/empSch), empSch.jsp(뷰)-->
</body>
</html>