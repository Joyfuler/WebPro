<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath}/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<form action = "${conPath }/join.do" method = "post">
	<table>
		<caption>회원가입페이지</caption>
			<tr>
				<td>ID: <input type = "text" name = "mid" class = "btn" required = "required"></td>
			</tr>
			<tr>
				<td>PW : <input type = "password" name = "mpw" size = "4" required = "required"></td>
			</tr>
			<tr>
				<td>이름 : <input type = "text" name = "mname" size = "4"></td>
			</tr>
			<tr>
				<td>메일주소 : <input type = "text" name = "memail" size = "4"></td>
			</tr>
			<tr>
				<td>생일: <input type = "date" name = "mbirth" size = "4"></td>
			</tr>
			<tr>
			<td colspan = "2"><input type = "submit" value = "회원가입" class = "btn"><input type = "button" onclick = "location.href='${conPath}/main.do'" value = "메인으로" class = "btn">					
	</table>
	</form>	
</body>
</html>