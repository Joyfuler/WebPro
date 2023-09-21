<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String conPath = request.getContextPath();%>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet">
</head>
<body>
<%
// 넘어온 패러미터 : bid, pageNum (원글의 글번호와 답글 수정 후에 가야할 페이지를 가져왔음.)
// 이후 bid를 통해 dto를 가져옴.
String pageNum = request.getParameter("pageNum");
int bid = Integer.parseInt(request.getParameter("bid"));
BoardDao bDao = BoardDao.getInstance();
BoardDto originalDto = bDao.getBoardNothitup(bid); //원글의 정보가져옴.
%>
<%=originalDto%>
	<form action = "<%=conPath%>/Board/replyPro.jsp" method = "post">	
	<table>
	<caption>댓글작성페이지</caption>
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
	<input type = "submit" value = "댓글작성" class = "btn">
	<input type = "reset" value = "초기화" class = "btn">
	<input type = "button" value = "게시글목록" class = "btn" onclick = "location.href='<%=conPath%>/Board/list.jsp'">
	</td>
	</tr>
	</table>
	
	</form>	
</body>
</html>