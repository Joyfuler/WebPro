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
<form action = "<%=conPath%>/lect2_book/bookRegisterPro.jsp" method = "post"
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
		<td><input type = "file" name = "bimg1"></td>
	</tr>
	<tr>
		<th>추가이미지</th>
		<td><input type = "file" name = "bimg2"></td>
	</tr>
	<tr>
		<th>책 소개</th>
		<td><textarea rows = "5" cols = "20" name = ""></textarea></td>
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
	<a href = "ex1_list.jsp">책 전체 리스트 (게시판 스타일)</a>	
	<a href = "ex2_listBoard_paging">책 리스트 페이징 (게시판스타일)</a>
	<a href = "ex3_listProduct_nopaging.jsp">책 전체 리스트 (상품 스타일)</a>	
	<a href = "ex4_listProduct.jsp">책 리스트 페이징 (상품스타일)</a>
</body>
</html>