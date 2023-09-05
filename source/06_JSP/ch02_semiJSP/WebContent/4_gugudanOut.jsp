<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<table>
	<caption> 6단 구구단 </caption>
	<% for (int i=1; i<=9; i++){%> 
	<%-- 사이에 html 스크립트를 입력해야 하므로 for문 여는 곳과 닫는 곳을 <%>로 감싼다. --%>
	<tr>
		<td> 6 * <%=i%> = <%=6*i%></td>
	</tr>			
	<%}%>
	
	</table>
</body>
</html>