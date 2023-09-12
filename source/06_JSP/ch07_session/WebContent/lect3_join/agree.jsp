<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>

<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String name = request.getParameter("name");
String pw = request.getParameter("pw");
 // 전달받은 파라미터를 세션에 추가 -> 다음 페이지와 그 후 페이지들에서도 사용하기 위함.
session.setAttribute("id", id);
session.setAttribute("pw", pw);
session.setAttribute("name", name);	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<h2><%=name%>님, 약관에 동의하십니까?</h2>
	<hr>
	<ol>
	<li>회원 정보는 웹사이트 운영을 위해서만 사용됩니다.</li>
	<li>웹 사이트의 정상적인 운영을 방해하는 회원은 탈퇴될 수 있습니다.</li>
	</ol>
	<hr>
	<fieldset>
	<legend>약관 동의</legend>
	<form action = "<%=conPath%>/lect3_join/joinOk.jsp">
	<input type = "radio" name = "agree" value = "yes" class = "btn">동의합니다.
	<input type = "radio" name = "agree" value = "no" class = "btn" checked = "checked">동의하지 않습니다.
	<input type = "submit" value = "확인" class = "btn">
	</form>
	</fieldset>
</body>
</html>