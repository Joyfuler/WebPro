<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String conPath = request.getContextPath();%>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/book/css/css/style.css" rel = 'stylesheet'>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<%
String fid = request.getParameter("fid");
String pageNum = request.getParameter("pageNum");
CustomerDto memberInfo = (CustomerDto)session.getAttribute("customer");
String cid = memberInfo.getCid();
if (fid == null){ // 
	response.sendRedirect(conPath + "/Fileboard/csList.jsp");
} else {
%>
	<table>
	<caption><%=fid%>번 글 삭제</caption>
	<tr>
		<td>
			<fieldset>
			<legend>삭제를 위한 암호 입력</legend>
			<form action = "<%=conPath%>/Fileboard/deletePro.jsp" method = "post">
			<input type = "hidden" name = "pageNum" value = "<%=pageNum%>">
			<input type = "hidden" name = "cid" value = "<%=cid%>">
			<input type = "hidden" name = "fid" value = "<%=fid%>">
			<p>암호 <input type = "password" name = "fpw" required = "required" autofocus = "autofocus" class = "btn"></p>			
			<input type = "submit" value = "삭제" class = "btn">			
			</form>
			<button onclick = "location.href='<%=conPath%>/Fileboard/content.jsp?fid=<%=fid%>'">삭제취소</button>
			</fieldset>
		</td>
	</table>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
<%}%>