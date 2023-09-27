<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<style>
tr {
	width: 1000px;
}
</style>
<link href="<%=conPath%>/customer/css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<%
		String pageNum = request.getParameter("pageNum");
	if (pageNum == null) {
		pageNum = "1";
	}
	int currentPage = Integer.parseInt(pageNum);
	final int PAGESIZE = 5, BLOCKSIZE = 2;
	int startRow = (currentPage - 1) * PAGESIZE + 1;
	int endRow = startRow + PAGESIZE - 1;
	CustomerDao cDao = new CustomerDao();
	ArrayList<CustomerDto> Lists = cDao.getCustomerList(startRow, endRow);
	out.println("<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;총 회원 수 : " + cDao.getCustomerCount() + "명</b><br>");
	out.println(
			"<table><tr><td><b>아이디</b></td><td><b>비밀번호</b></td><td><b>이름</b></td><td><b>이메일</b></td><td><b>주소</b></td></tr>");
	for (int idx = 0; idx < Lists.size(); idx++) {
		out.println("<tr><td>" + Lists.get(idx).getCid() + "</td>");
		out.println("<td>" + Lists.get(idx).getCpw() + "</td>");
		out.println("<td>" + Lists.get(idx).getCname() + "</td>");
		out.println("<td>" + Lists.get(idx).getCemail() + "</td>");
		out.println("<td>" + Lists.get(idx).getCaddress() + "</td>");
	}
	out.println("</tr></table>");
	%>
	<div class="paging">
		<%
			int pageCnt = (int) Math.ceil((double) cDao.getCustomerCount() / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		if (startPage > BLOCKSIZE * 2) {
		%>
		<a href="<%=conPath%>/customer/customerList.jsp?pageNum=1">[처음으로]</a>
		<%
			}
		%>
		<%
			if (startPage > BLOCKSIZE) {
		%>
		<a
			href="<%=conPath%>/customer/customerList.jsp?pageNum=<%=startPage - 1%>">[이전]</a>
		<%
			}
		%>

		<%
			for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) { // 동일한페이지면 링크 x, b태그로
				out.print("<b>[" + i + "]</b>");
			} else {
				out.print("<a href ='" + conPath + "/customer/customerList.jsp?pageNum=" + i + "'>[" + i + "]</a>");
			}
		}
		if (endPage < pageCnt) {
		%>
		<a
			href="<%=conPath%>/customer/customerList.jsp?pageNum=<%=endPage + 1%>">[다음]</a>
		<%
			}
		if (endPage < pageCnt - BLOCKSIZE) {
		%>
		<a href="<%=conPath%>/customer/customerList.jsp?pageNum=<%=pageCnt%>">[마지막]</a>
		<%
			}
		%>
	</div>

	<jsp:include page="../main/footer.jsp" />
</body>
</html>