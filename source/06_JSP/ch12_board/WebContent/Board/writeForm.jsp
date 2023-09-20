<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet">
</head>
<body>
	<form action = "<%=conPath%>/Board/writePro.jsp" method = "post">
	<%-- 글작성의 경우 글 내용이 매우 길어지므로 get으로 보낼 수가 없음. 무조건 post를 사용해야 함. --%>
	<table>
	<caption>게시글작성페이지</caption>
	<tr><th>작성자</th>
	<td><input type = "text" name = "bname" required = "required" autofocus="autofocus"></td>
	</tr>
	<tr><th>글제목</th>
	<td><input type = "text" name = "btitle" required = "required"></td>
	</tr>
	<tr><th>글내용</th>
	<td><textarea rows="10" name = "bcontent"></textarea></td>
	</tr>
	<tr><th>이메일</th>
	<td><input type = "email" name = "bemail"></td>
	</tr>
	<tr><th>비밀번호</th>
	<td><input type = "password" name = "bpw" required = "required"></td>
	</tr>	
	<tr><td colspan = "2">
	<input type = "submit" value = "게시글작성" class = "btn">
	<input type = "reset" value = "초기화" class = "btn">
	<input type = "button" value = "게시글목록" class = "btn" onclick = "location.href='<%=conPath%>/Board/list.jsp'">
	</td>
	</tr>
	</table>
	
	</form>	
</body>
</html>