<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<h1> ex2_scope.jsp 페이지입니다</h1>
<h3> 페이지 내 attribute : ${pageName }</h3>
<h3> request attribute : ${requestName} </h3>
<h3> session attribute : ${sessionName }</h3>
<h3> application 내 attribute : ${appName}</h3>
<h3> 넘어온 id 패러미터 : ${param.id }</h3>
<h3> 넘어온 pw 패러미터 : ${param.pw }</h3>
</body>
</html>