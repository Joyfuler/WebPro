<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! String conPath;%>
    <% conPath = request.getContextPath();  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/ex.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<h1> ex5_include.jsp 페이지입니다.</h1>	
	<hr>
	<p> 헤더나 푸터입니다</p>
	<hr>
	<jsp:include page = "includedPage.jsp"/>
</body>
</html>