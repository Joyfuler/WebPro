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
<!--  requeScope.modifyBoard, param bid, param Pagenum 받아왔음 -->
	<form action = "${conPath }/modify.do" method = "post" enctype="multipart/form-data">	
	<input type = "text" name = "bid" value = "${param.bid }">
	<input type = "text" name = "pageNum" value = "${param.pageNum }">
		<table>
		<caption>${param.bid }번 글 수정</caption>
		<tr>
			<th>작성자</th>
			<td><input type = "text" name = "bname" required = "required" 
			autofocus="autofocus" value = "${board.bname }"></td>
		</tr>
		<tr>	
			<th>글제목</th>
			<td><input type = "text" name = "btitle" required = "required"
			 value = "${board.btitle }"></td>
		</tr>
		<tr>	
			<th>글본문</th>
			<td><textarea rows="5" name = "bcontent">${board.bcontent }</textarea></td>
		</tr>
		<tr>
			<th>파일첨부</th>
			<td><input type = "file" name = "bfileName"></td>
		</tr>	
		<tr>	
			<td colspan = "2">
				<input type = "submit" value = "글수정" class = "btn">
				<input type = "reset" value = "취소" class = "btn" onclick = "history.back()">
				<!--  상세보기 -> 수정이므로, 수정에서 history.back하면 상세보기로 감. -->
				<input type = "button" value = "목록" class = "btn" onclick = "location='${conPath}/boardList.do?pageNum=${param.pageNum }'">
			<!--  submit을 누를 경우 write.do로 요청보냄. -->
			</td>
		</tr>	
		</table>	
	</form>
</body>
</html>