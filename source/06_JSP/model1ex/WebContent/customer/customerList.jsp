<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
tr{
width: 1000px;}
</style>
<link href = "css/style.css" rel = "stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% CustomerDao cDao = new CustomerDao();
ArrayList<CustomerDto> Lists = cDao.getCustomerList();
out.println("<table><tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>주소</td></tr>");
for (int idx =0; idx <Lists.size(); idx++){
	out.println("<tr><td>"+Lists.get(idx).getCid() + "</td>");
	out.println("<td>"+Lists.get(idx).getCpw() + "</td>");
	out.println("<td>"+Lists.get(idx).getCname() + "</td>");	
	out.println("<td>"+Lists.get(idx).getCemail() + "</td>");
	out.println("<td>"+Lists.get(idx).getCaddress() + "</td>");	
}
out.println("</tr></table>");
%>
</body>
</html>