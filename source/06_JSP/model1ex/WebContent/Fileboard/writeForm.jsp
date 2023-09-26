<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String conPath = request.getContextPath();
CustomerDto customer = (CustomerDto)session.getAttribute("customer");
if (customer ==null){	
	response.sendRedirect(conPath+"/customer/loginForm.jsp?method=writeForm");
} else {
%>
<link href = "<%=conPath%>/Fileboard/css/style.css" rel = "stylesheet">
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<form action = "<%=conPath%>/Fileboard/writePro.jsp" method = "post" enctype = "multipart/form-data">
	<input type = "hidden" name = "cid" value = "<%=customer.getCid()==null? "aaa1":customer.getCid()%>">	
	<table>
	<caption>게시글작성페이지</caption>
	<tr><th>작성자</th>
	<td><input type = "text" name = "fname" required = "required" value = "<%=customer.getCname()%>" readonly = "readonly"></td>
	</tr>
	<tr><th>글제목</th>
	<td><input type = "text" name = "ftitle" required = "required"></td>
	</tr>
	<tr><th>글내용</th>
	<td><textarea rows="10" name = "fcontent"></textarea></td>
	</tr>
	<tr><th>파일첨부</th>
	<td><input type = "file" name = "file"></td>
	</tr>
	<tr><th>비밀번호</th>
	<td><input type = "password" name = "fpw" required = "required"></td>
	</tr>	
	<tr><td colspan = "2">
	<input type = "submit" value = "게시글작성" class = "btn">
	<input type = "reset" value = "초기화" class = "btn">
	<input type = "button" value = "게시글목록" class = "btn" onclick = "location.href='<%=conPath%>/Fileboard/csList.jsp'">
	</td>
	</tr>
	</table>
	
	</form>	
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<%}%>