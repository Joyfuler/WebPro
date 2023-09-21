<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String conPath = request.getContextPath();%>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = 'stylesheet'>
</head>
<body>
<%
String bid = request.getParameter("bid");
if (bid == null){ // 
	response.sendRedirect(conPath + "/Board/list.jsp");
}
%>
	<table>
	<caption><%=bid%>번 글 삭제</caption>
	<tr>
		<td>
			<fieldset>
			<legend>삭제를 위한 암호 입력</legend>
			<form action = "<%=conPath%>/Board/deletePro.jsp" method = "post">
			<input type = "hidden" name = "bid" value = "<%=bid%>">
			<p>암호 <input type = "password" name = "bpw" required = "required" autofocus = "autofocus" class = "btn"></p>			
			<input type = "submit" value = "삭제" class = "btn">
			<button onclick = "history.back()">삭제취소</button>
			</form>
			</fieldset>
		</td>
	</table>

</body>
</html>