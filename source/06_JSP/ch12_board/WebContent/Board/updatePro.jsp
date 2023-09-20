<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String conPath = request.getContextPath(); %>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="dto" class = "com.lec.ex.dto.BoardDto"/>
<jsp:setProperty property="*" name="dto"/>
<%--들어온 패러미터는 bid, bname, btitle, bcontent, bemail, bpw --%>
<%String bip = request.getRemoteAddr();
dto.setBip(bip);
BoardDao bDao = BoardDao.getInstance();
int result = bDao.modifyBoard(dto);
if (result == BoardDao.SUCCESS){
	%>
	<script>
	alert("수정완료");
	location.href = "<%=conPath%>/Board/content.jsp?bid=<%=dto.getBid()%>";
	</script>
<%} else {%>
	<script>
	alert("수정실패. 게시글로 돌아갑니다.(제목 혹은 닉네임 길이를 확인해주세요)");
	location.href = "<%=conPath%>/Board/content.jsp?bid=<%=dto.getBid()%>";
</script>
<%}%>

</body>
</html>