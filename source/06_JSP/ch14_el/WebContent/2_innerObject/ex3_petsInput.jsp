<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<form action = "ex4_petsResult.jsp">
	ID <input type = "text" name = "id"><br>
	키우는 애완동물을 선택하세요
	<input type = "checkbox" name = "pets" value = "개">개
	<input type = "checkbox" name = "pets" value = "고양이">고양이
	<input type = "checkbox" name = "pets" value = "앵무새">앵무새
	<input type = "checkbox" name = "pets" value = "열대여">열대어
	<input type = "submit" value = "제출">	
	</form>
</body>
</html>