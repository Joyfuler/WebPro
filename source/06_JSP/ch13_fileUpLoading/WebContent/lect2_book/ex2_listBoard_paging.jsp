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
<%
String pageNum = request.getParameter("pageNum");
if (pageNum == null){
	pageNum = "1";
}
int currentPage = Integer.parseInt(pageNum);
final int PAGESIZE = 6, BLOCKSIZE = 2;
int startRow = (currentPage -1) * PAGESIZE + 1;
int endRow = startRow + PAGESIZE -1;
BookDao bDao = BookDao.getInstance();
ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
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
	<tr><td><%=bid%></td><td><a href = "<%=conPath%>/lect2_book/content.jsp?bid=<%=bid%>"><%=book.getBtitle()%></a></td>
	<td><a href = "<%=conPath%>/lect2_book/content.jsp?bid=<%=bid%>"><img src = '../bookImg/<%=book.getBimg1()%>' alt = "대표이미지" width = "15"></a></td>
	<td><del><%=price%></del><b><%=disPrice%>원(<%=discount%>% 할인)</b></td>
	<td><%=discount%></td>		
	</tr>		
		<%}%>
	<%}%>
</table>
	<div class = "paging">
	<%
	int pageCnt = (int)Math.ceil((double)bDao.getBookTotalCnt() /PAGESIZE);
	int startPage = ((currentPage-1) / BLOCKSIZE)*BLOCKSIZE + 1;
	int endPage = startPage + BLOCKSIZE -1;
	if (endPage > pageCnt){
		endPage = pageCnt;
	}
	if (startPage > BLOCKSIZE){ // 10페이지까지 있는데 내가 17페이지에 있으면 시작페이지가 11
		%>
		<a href = "ex2_listBoard_paging.jsp?pageNum=<%=startPage-1%>">[이전]</a>		
	<%}%>
	<%for (int i = startPage; i<=endPage; i++){
		if (i == currentPage){ // 동일한페이지면 링크 x, b태그로
		out.print("<b>["+i+"]</b>");
		} else {
			out.print("<a href ='ex2_listBoard_paging.jsp?pageNum="+i+"'>[" + i + "]</a>");
		}		
	}
	if (endPage < pageCnt){%>
		<a href = "ex2_listBoard_paging.jsp?pageNum=<%=endPage+1%>">[다음]</a>
	<%}%>	
	</div>
</body>
</html>