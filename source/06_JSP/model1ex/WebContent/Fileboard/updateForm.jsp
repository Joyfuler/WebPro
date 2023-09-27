<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=conPath%>/customer/css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<%
		String pageNum = request.getParameter("pageNum");
	String fid = request.getParameter("fid");
	if (fid == null) {
		response.sendRedirect(conPath + "/Fileboard/csList.jsp");
	} else {
		FileBoardDao fDao = FileBoardDao.getInstance();
		FileBoardDto dto = fDao.csBoardDetail(fid); // 메소드 타입보고 = 으로 받자!
		CustomerDao cDao = CustomerDao.getInstance();
		CustomerDto cDto = cDao.getCustomerDto(dto.getCid());
	%>
	<form
		action="<%=conPath%>/Fileboard/updatePro.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>"
		method="post" enctype="multipart/form-data">
		<%-- 글작성의 경우 글 내용이 매우 길어지므로 get으로 보낼 수가 없음. 무조건 post를 사용해야 함. --%>
		<input type="hidden" name="cid" value="<%=cDto.getCid()%>"> <input
			type="hidden" name="fid" value="<%=fid%>"> <input
			type="hidden" name="pageNum" value="<%=pageNum%>"> <input
			type="hidden" name="dbFile" value="<%=dto.getFilename()%>">
		<table>
			<caption>게시글수정</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="fname" required="required"
					autofocus="autofocus" value="<%=cDto.getCname()%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="ftitle" required="required"
					value="<%=dto.getFtitle()%>"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea rows="10" name="fcontent"><%=dto.getFcontent() == null ? "" : dto.getFcontent()%></textarea></td>
				<!-- textarea의 경우는 value가 아니라 사이에 넣어야 함! -->
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="femail"
					value="<%=cDto.getCemail() == null ? "" : cDto.getCemail()%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="file" style="width: 50%"><%=dto.getFilename() == null ? "첨부파일없음" : "현재파일: " + dto.getFilename()%></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="fpw" required="required"
					value="<%=dto.getFpw()%>"></td>
				<%}	%>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="게시글수정" class="btn">
					<input type="reset" value="초기화" class="btn"> <input
					type="button" value="게시글목록" class="btn"
					onclick="location.href='<%=conPath%>/Fileboard/csList.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>