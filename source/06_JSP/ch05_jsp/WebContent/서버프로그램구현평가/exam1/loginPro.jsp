<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String conPath = request.getContextPath();
    %>
    
    <%!String id; String pw; %>
    <% String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    if (!id.equals("aaa")|| !pw.equals("111")){
    	String msg = "<h4>잘못 입력하셨습니다. 아이디와 비밀번호를 확인하세요</h4>";
    	msg = URLEncoder.encode(msg,"UTF-8");
    	response.sendRedirect("login.jsp?msg="+msg);
    }
    else{
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "login.css" rel = "stylesheet">
</head>
<body>
	<fieldset>결과 화면
	<hr>
	<h3> 아이디는 <%=id%>이고</h3>
	<h3>비밀번호는 <%=pw %>입니다.</h3>	
	<h3>반갑습니다.</h3>
	</fieldset>
<%} %>
</body>
</html>