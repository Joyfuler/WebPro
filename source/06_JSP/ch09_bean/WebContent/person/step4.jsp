<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>

<!-- process단 -->
<jsp:useBean id="person" class = "com.lec.ex.Person" scope = "request"></jsp:useBean>
<jsp:setProperty name = "person" property="name" param = "name"/>
<jsp:setProperty name = "person" property="age" param = "age"/>
<jsp:setProperty name = "person" property="gender" param = "gender"/>
<jsp:setProperty name = "person" property="address" param = "address"/>
<jsp:forward page="personView.jsp"></jsp:forward>
</body>
</html>