<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이 파일은 hello.jsp입니다.</h1>
	<% //	scriptric태그 (html 내부 자바)
	int total = 0;
	for (int cnt=1; cnt<=100; cnt++){
		total += cnt;		
	}
	%>
	<h2>1부터 100까지 누적합은 <%=total%> 입니다.</h2>	
	 <!-- 표현식. 자바 명령어 소스를 넣을 때 = 을 넣어주자. -->
</body>
</html>