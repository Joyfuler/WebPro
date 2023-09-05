<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	table {
	border : 2px solid navy;
	}
	
	.logintd {
	border-bottom: 1px solid navy;	
	}
	
	
	.loginButton{
	display:inline-flex;
	background: linear-gradient( 45deg, darkblue, skyblue);
	color: white;
	}
	
	input{
	border: 1px solid navy;}
	
	table tr td {
	text-align:center;}
	
	
	</style>
	
	
	
	
	
</head>
<body>
	<form action = "6_loginPro.jsp"  method = "post">
	<table>
	<tr>
	<td colspan = "3" class="logintd">로그인 화면</td>	
	</tr>
	
	<tr><td>이 름 </td><td><input type = "text" name = "name"></td></tr>
	<tr><td>아이디</td><td><input type = "text" name = "id"></td></tr>
	<tr><td>패스워드</td><td><input type = "password" name = "pw"></td></tr>
	<tr><td colspan="2"><input type = "submit" value = "로그인" class = "loginButton"></td></tr>
	</table>
	</form>
</body>
</html>