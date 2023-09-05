<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!--  현재위치는 ex/ex3_gugudan.jsp -->
<!--  servlet 위치는 Ex3 (구구단 출력 servlet 위치).. 실제로는 src에 있지만, servlet의 경우는 이와 같이 표시 가능 --> 
	<h2>출력을 원하는 구구단을 선택하세요.</h2>
	<form action = "../Ex3" method = "get">	
	<select name = "num">
	<option value ="2">2단</option>
	<option value ="3">3단</option>
	<option value ="4">4단</option>
	<option value ="5">5단</option>
	<option value ="6">6단</option>
	<option value ="7">7단</option>
	<option value ="8">8단</option>
	<option value ="9">9단</option>
	</select>
	<input type = "submit" value = "구구단출력">
	</form>		
</body>
</html>