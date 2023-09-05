<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href = "../css/ex2.css" rel = "stylesheet" text = "text/css">
</head>
<body>
<!--  현재 위치는 /ch03_semiServlet/ex/ex2_suInt.jsp -->
<!--  parameter를 받아 처리할 서블릿의 주소는 ch03_semiServlet/Ex2 -->
	<h2>1부터 얼마까지 누적할지 자연수를 입력하세요.</h2>
	<form action = "../Ex2" method = "post">
	<p>이 름 <input type = "text" name = "name"></p>
	<p>자연수<input type = "number" name = "num" min = "1" required = "required"></p>
	 <p><input type = "submit" value = "출력"></p>
	</form>
		
</body>
</html>