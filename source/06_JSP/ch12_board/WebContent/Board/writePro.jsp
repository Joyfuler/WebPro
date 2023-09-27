<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="com.lec.ex.dto.BoardDto" />
<jsp:setProperty property="*" name="dto" />
</head>
<%
	dto.setBip(request.getRemoteAddr()); // 글쓰기를 요청한 컴퓨터 ip
	BoardDao bDao = BoardDao.getInstance();
	int result = bDao.writeBoard(dto);
	if (result == BoardDao.SUCCESS) {
%>
<script>
	alert("게시글작성 완료. 리스트로 돌아갑니다.");
	location.href = "<%=conPath%>/Board/list.jsp";
	</script>
<%} else {%>
<script>
	alert("오류 발생: 게시글작성 실패. 이름이나 제목 길이를 확인해주세요");
	location.href = "<%=conPath%>
	/Board/list.jsp";
</script>
<%}%>
<body>
</body>
</html>