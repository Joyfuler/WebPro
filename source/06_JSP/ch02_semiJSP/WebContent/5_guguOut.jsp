<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	caption{
	width: 500px;
	text-align: left;}
	</style>
</head>
<body>
	
	<!--  5_guguin에서 넘긴 su parameter를 받는 방법!! -->
		<%=request.getParameter("su") %> <br>
		<%-- parameter로 넘어온 su는 반드시 string 타입이므로, 숫자 계산을 위해서는 형변환을 해 주어야 함. --%>
		<% int su = Integer.parseInt(request.getParameter("su")); %>
		<%--  넘어온 "su"를 java의 int su로 형변환! --%>
		<table>
		<caption><%=su%>단 구구단</caption>		
		<% for(int i=1; i<10; i++){ %>
		<tr>
		<td><%= su + "*" + i + "=" + (su*i) %></td>
		</tr>
		<%}%>		
		</table>
		
</body>
</html>