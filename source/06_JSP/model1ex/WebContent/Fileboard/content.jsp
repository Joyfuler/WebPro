<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
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
<link href="<%=conPath%>/Fileboard/css/style.css" rel="stylesheet"
	type="text/css">
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<%
		String fidStr = request.getParameter("fid");
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	if (fidStr == null) {
		response.sendRedirect("csList.jsp");
	} else {
		String pageNum = request.getParameter("pageNum");
		FileBoardDao fDao = FileBoardDao.getInstance();
		FileBoardDto dto = fDao.csBoardDetail(fidStr); // bid로 정보출력		
		CustomerDao cDao = CustomerDao.getInstance();
		CustomerDto writerInfo = cDao.getCustomerDto(dto.getCid());
	%>
	<table>
		<caption><%=fidStr%>번 글 상세보기
		</caption>
		<tr>
			<th>글번호</th>
			<td><%=dto.getFid()%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><b><%=writerInfo.getCname()%>(<%=writerInfo.getCemail()%>)</b></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><%=dto.getFtitle()%></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td>
				<%
					if (dto.getFilename() != null
						&& (dto.getFilename().substring(dto.getFilename().length() - 3, dto.getFilename().length()).equals("jpg") || dto
						.getFilename().substring(dto.getFilename().length() - 3, dto.getFilename().length()).equals("png"))) {
				%>
				<img src='<%=conPath%>/fileboardUpload/<%=dto.getFilename()%>'
				alt='빈그림'><br> <%
 	} else {
 %> 첨부된 파일 : <a
				href='<%=conPath%>/fileboardUpload/<%=dto.getFilename()%>'><%=dto.getFilename()%></a>
				<%
					}
				%> <pre><%=dto.getFcontent() == null ? "글내용 없음" : dto.getFcontent()%></pre>
			</td>
			<!--  pre 태그 - 원래 엔터가 존재하는 경우 해당 내용을 모두 그대로 출력 -->
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getCemail() == null ? "이메일없음" : dto.getCemail()%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=dto.getFhit()%></td>
		</tr>
		<tr>
			<th>IP</th>
			<td><%=dto.getFip()%></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=dto.getFrdate()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<%
					if (customer != null && dto.getCid() != null && dto.getCid().equals(customer.getCid())) {
				%>
				<button
					onclick="location.href='<%=conPath%>/Fileboard/updateForm.jsp?fid=<%=fidStr%>&pageNum=<%=pageNum%>'">글수정</button>
				<%}%>
				
				<%
					if (customer != null && dto.getCid() != null && dto.getCid().equals(customer.getCid())) {
				%>
				<button
					onclick="location.href='<%=conPath%>/Fileboard/deleteForm.jsp?fid=<%=fidStr%>&pageNum=<%=pageNum%>'">글삭제</button>
				<%}	%>
				
				<%			
					if (customer != null) {
				%>				
				<button
					onclick="location.href='<%=conPath%>/Fileboard/replyForm.jsp?fid=<%=fidStr%>&pageNum=<%=pageNum%>'">답변</button>
				<%}%>	
				<button
					onclick="location.href ='<%=conPath%>/Fileboard/csList.jsp?pageNum=<%=pageNum%>'">글목록</button>
			</td>
	</table>
	<%}	%>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>