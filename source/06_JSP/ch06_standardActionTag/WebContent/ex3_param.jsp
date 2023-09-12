<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 요청 url : ex3_param.jsp?n=1 --%>
	<h2> ex3_param.jsp 페이지입니다. </h2>
	<jsp:forward page="ex_4.jsp">
		<jsp:param name="id" value="aaa"/>
		<jsp:param name = "pw" value = "111"/>	
	</jsp:forward>

</body>
</html>