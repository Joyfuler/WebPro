<%@page import="com.lec.ex.BookDto"%>
<%@page import="java.util.ArrayList"%>
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
<% BookDao bDao = BookDao.getInstance();
ArrayList<BookDto> books = bDao.listBook();
String pageNum = request.getParameter("pageNum");
%>
<table>
	<caption> 책 리스트 (board Style)</caption>
	<tr><th>책 ID </th><th>책 이름</th><th>책 표지</th><th>가격</th><th>할인율</th></tr>
	<%
		if (books.size()==0){%>	
		<tr><td colspan='5'>등록된 책이 없습니다</td></tr>
	<%}else{ 
	for (BookDto book: books){
	int bid = book.getBid();
	int price = book.getBprice();
	int discount = book.getBdiscount();
	int disPrice = price * (100-discount) / 100;	
	%>
	<tr><td><%=bid%></td><td><a href = "<%=conPath%>/lect2_book/content.jsp?bid=<%=bid%>&pageNum=<%=pageNum%>"><%=book.getBtitle()%></a></td>
	<td><a href = "<%=conPath%>/lect2_book/content.jsp?bid=<%=bid%>"><img src = '../bookImg/<%=book.getBimg1()%>' alt = "대표이미지" width = "15"></a></td>
	<td><del><%=price%></del><b><%=disPrice%>원(<%=discount%>% 할인)</b></td>
	<td><%=discount%></td>		
	</tr>		
		<%}%>
	<%}%>
</table>

</body>
</html>