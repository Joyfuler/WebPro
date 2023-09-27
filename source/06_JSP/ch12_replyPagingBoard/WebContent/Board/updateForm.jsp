<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		String bidStr = request.getParameter("bid");
	if (bidStr == null) {
		response.sendRedirect(conPath + "/Board/list.jsp");
	} else {
		int bid = Integer.parseInt(bidStr);
		BoardDao bDao = BoardDao.getInstance();
		BoardDto dto = bDao.getBoardNothitup(bid); // 메소드 타입보고 = 으로 받자!
	%>
	<form action="<%=conPath%>/Board/updatePro.jsp" method="post">
		<%-- 글작성의 경우 글 내용이 매우 길어지므로 get으로 보낼 수가 없음. 무조건 post를 사용해야 함. --%>
		<input type="hidden" name="bid" value="<%=bid%>"> <input
			type="hidden" name="pageNum" value="<%=pageNum%>">
		<table>
			<caption>게시글수정</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required"
					autofocus="autofocus" value="<%=dto.getBname()%>"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required="required"
					value="<%=dto.getBtitle()%>"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea rows="10" name="bcontent"><%=dto.getBcontent() == null ? "" : dto.getBcontent()%></textarea></td>
				<!-- textarea의 경우는 value가 아니라 사이에 넣어야 함! -->
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="bemail"
					value="<%=dto.getBemail() == null ? "" : dto.getBemail()%>"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="bpw" required="required"
					value="<%=dto.getBpw()%>"></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="게시글수정" class="btn">
					<input type="reset" value="초기화" class="btn"> <input
					type="button" value="게시글목록" class="btn"
					onclick="location.href='<%=conPath%>/Board/list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>