<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String conPath = request.getContextPath();
%>
<link href="<%=conPath%>/book/css/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<%
		// 넘어온 패러미터 : bid, pageNum (원글의 글번호와 답글 수정 후에 가야할 페이지를 가져왔음.)
	// 이후 bid를 통해 dto를 가져옴.

	String pageNum = request.getParameter("pageNum");
	String fid = request.getParameter("fid");
	FileBoardDao fDao = FileBoardDao.getInstance();
	FileBoardDto originalDto = fDao.csBoardDetail(fid); //원글의 정보가져옴.
	CustomerDao cDao = CustomerDao.getInstance();
	CustomerDto customer = (CustomerDto) session.getAttribute("customer");
	%>
	원본 정보:
	<%=originalDto%>
	수정하는사람 cid:
	<%=customer.getCid()%>
	<form
		action="<%=conPath%>/Fileboard/replyPro.jsp?cid=<%=customer.getCid()%>"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="<%=pageNum%>"> <input
			type="hidden" name="fid" value="<%=originalDto.getFid()%>"> <input
			type="hidden" name="fgroup" value="<%=originalDto.getFgroup()%>">
		<input type="hidden" name="fstep" value="<%=originalDto.getFstep()%>">
		<input type="hidden" name="findent"
			value="<%=originalDto.getFindent()%>">
		<table>
			<caption>댓글작성페이지</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="fname" required="required"
					value="<%=customer.getCname()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="ftitle"
					value="re: <%=originalDto.getFtitle()%>" required="required"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea rows="10" name="fcontent"></textarea></td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="fpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="댓글작성" class="btn">
					<input type="reset" value="초기화" class="btn"> <input
					type="button" value="게시글목록" class="btn"
					onclick="location.href='<%=conPath%>/Fileboard/csList.jsp'">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>
