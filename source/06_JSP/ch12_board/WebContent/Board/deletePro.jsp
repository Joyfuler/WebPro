<%@page import="com.lec.ex.dao.BoardDao"%>
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
	int bid = Integer.parseInt(request.getParameter("bid"));
	String bpw = request.getParameter("bpw");
	BoardDao bDao = BoardDao.getInstance();
	int result = bDao.deleteBoard(bid, bpw);
	if (result == BoardDao.SUCCESS) { //비밀번호가 일치하여 정상적으로 삭제됨
	%>
	<script>
		alert('<%=bid%>번 게시글 삭제 완료. 리스트로 돌아갑니다');
		location.href = "<%=conPath%>/Board/list.jsp";
		</script>

	<%
		} else {
	%>
	<script>
		alert('비밀번호가 틀려 삭제하지 못했습니다. 다시 시도하세요');
		location.href = "<%=conPath%>/Board/deleteForm.jsp?bid=<%=bid%>";
	</script>
	<%}%>
</body>
</html>