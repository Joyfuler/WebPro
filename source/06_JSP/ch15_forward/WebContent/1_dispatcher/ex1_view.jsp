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
	<h1>회원정보(ex1_view.jsp페이지입니다)</h1>
	<h3> 회원: ${member }</h3>
	<%--request.setAttribute를 하여 넘어왔으므로 (requestScope)member사용가능 --%>
	<h3> 회원아이디 : ${member.id }</h3>
	<h3> 회원이름 : ${member.name }</h3>
	<h3> 회원비밀번호 : ${member.pw }</h3>
</body>
</html>