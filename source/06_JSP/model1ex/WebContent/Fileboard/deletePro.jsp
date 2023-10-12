<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String conPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int fid = Integer.parseInt(request.getParameter("fid"));
		String fpw = request.getParameter("fpw");
		String pageNum = request.getParameter("pageNum");
		String cid = request.getParameter("cid");
		FileBoardDao fDao = FileBoardDao.getInstance();
		int result = fDao.removecsBoard(cid, fpw);		
		if (result == FileBoardDao.SUCCESS) { //비밀번호가 일치하여 정상적으로 삭제됨%>
	<script>
		alert('<%=fid%>번 게시글 삭제 완료. 리스트로 돌아갑니다');
		location.href = "<%=conPath%>/Fileboard/csList.jsp?pageNum=<%=pageNum%>";
	</script>
	<%} else {%>
	<script>
		alert('비밀번호가 틀려 삭제하지 못했습니다. 다시 시도하세요');
		history.back();
	</script>
	<%}%>
</body>
</html>