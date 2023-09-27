<%@page import="ch14_el.Member"%>
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
	<%
	Member member = new Member("aaa","111","홍길동");
	request.setAttribute("member", member); // forward
	%>
	<h1> 회원정보 (el표기법)</h1>
	<h3> member 모든데이터 : ${member }</h3>
	<h3> ID : ${member.id }</h3> <%-- 기존 방식이라면 member.getId() 등으로 가져왔던 것 --%>
	<h3> PW : ${member.pw }</h3>
	<h3> name : ${member.name }</h3>	
</body>
</html>