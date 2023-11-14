<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/style.css" rel = "stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<script>
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<form action = "${conPath }/book/register.do" method = "post" enctype = "multipart/form-data">
	<table>
		<caption> 책등록하기</caption>
	<tr>
		<td>
			책이름 : <input type = "text" name = "btitle">
		</td>
	</tr>
	<tr>	 
		<td>
			작가명 : <input type = "text" name = "bwriter">			
		</td>
	</tr>
	<tr>	
		<td>	
			출판일: <input type = "date" name = "brdate">
		</td>
	</tr>
	<tr>	
		<td>	
			책표지: <input type = "file" name = "tempbimg1">
		</td>
	</tr>
	<tr>	
		<td>	
			책표지2: <input type = "file" name = "tempbimg2">
		</td>
	</tr>
	<tr>		
		<td>
			책설명: <input type = "text" name = "binfo">			
		</td>
	</tr>	
	<tr>
		<td colspan ="2">
			<input type = "submit" value = "등록">
		</td>
	</tr>	
	</table>
	</form>
</body>
</html>