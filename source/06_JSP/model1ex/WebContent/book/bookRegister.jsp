<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/book/css/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<jsp:include page="/main/header.jsp"/>
<form action = "<%=conPath%>/book/bookRegisterPro.jsp" method = "post"
	enctype = "multipart/form-data">
	<table>
	<caption>책등록</caption>
	<tr>
		<th>책 제목</th>
		<td><input type = "text" name = "btitle" maxlength="33" autofocus = "autofocus" required = "required"></td>
	</tr>
	<tr>
		<th>책 가격</th>
		<td><input type = "text" name = "bprice" min="0" max = "999999" required = "required"></td>
	</tr>
	<tr>
		<th>대표이미지</th>
		<td><input type = "file" name = "bimage1"></td>
	</tr>
	<tr>
		<th>추가이미지</th>
		<td><input type = "file" name = "bimage2"></td>
	</tr>
	<tr>
		<th>책 소개</th>
		<td><textarea rows = "5" cols = "20" name = "bcontent"></textarea></td>
		<tr>
		<th>할인율</th>
		<td><input type = "number" name = "bdiscount" min = "0" max = "100" value = "0" required = "required"></td>
	</tr>
	<tr>
	<td colspan="2"> <input type = "submit" value = "책등록" class = "btn">
	</tr>	
	</table>	
	</form>
	<hr>
	<a href = "<%=conPath%>/book/bookList.jsp">책 전체 리스트 (게시판 스타일- 페이징)</a>
<jsp:include page="/main/footer.jsp"/>	
</body>
</html>