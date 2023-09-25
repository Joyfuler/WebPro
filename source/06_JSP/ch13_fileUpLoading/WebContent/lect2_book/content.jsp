<%@page import="com.lec.ex.BookDto"%>
<%@page import="com.lec.ex.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<%
	String bidStr = request.getParameter("bid");
	if (bidStr == null){
		response.sendRedirect("ex1_list.jsp");
	}else{ 
		int bid = Integer.parseInt(bidStr);
		String pageNum = request.getParameter("pageNum");
		BookDao bDao = BookDao.getInstance();
		BookDto book = bDao.getBook(bid); // bid로 정보출력	
	%>
	<table>
		<tr>
			<td rowspan="4">
				<img src = "<%=conPath%>/bookImg/<%=book.getBimg1()%>">
			</td>
			<td><%=book.getBid()%></td>
		</tr>
		<tr>
			<td><%=book.getBtitle()%></td>	
		</tr>
		<tr>
			<td><del><%=book.getBprice()%></del><br>
			<b><%=book.getBprice() * (100-book.getBdiscount())/100 %>원<br>
			(<%=book.getBdiscount()%>% 할인됨)
			</b>
			</td>
		</tr>
		<tr>
			<td>		
				<button>구매</button>
				<button onclick = "location.href = 'ex4_listProduct_paging.jsp?pageNum=<%=pageNum%>'">목록</button>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<img src = "<%=conPath%>/bookImg/<%=book.getBimg2()%>"><br>	
				<pre><%=book.getBcontent() == null? "설명이 없습니다." : book.getBcontent() %></pre>
	</table>
</body>
</html>
<%}%>