<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<BookDto> books = bDao.listBook(startRow,endRow);
%>
	<table>
	<caption> 책 리스트 </caption>
	<tr>
	<%
	if (books.isEmpty()){
		out.print("<td>등록된 책이 없습니다.</td>");
	} else {
		for (int i=0 ; i<books.size(); i++){
			int bid = books.get(i).getBid(); //일반for문이므로 get(i)를 써줘야함.
			int price = books.get(i).getBprice();
			int discount = books.get(i).getBdiscount();
			int disPrice = price * (100-discount) / 100;
			if (i != 0 && i%3==0){
				out.print("</tr><tr>");
			}
		%>
			<td>
				<a href = "content.jsp?bid=<%=bid%>">
					<img src = "<%=conPath%>/bookImg/<%=books.get(i).getBimg1()%>"><br>
					<%=bid%>. <%=books.get(i).getBtitle()%><br>				
				</a>
				<del><%=price%></del><br>
				<b><%=disPrice%>원(<%=discount%>% 할인)</b>
			</td>
		<%	
			//if (i%3==2){out.print("</tr><tr>");}
		} // for
	} // if
	%>	
	</tr>		
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
		<a href = "ex4_listProduct_paging.jsp?pageNum=<%=startPage-1%>">[이전]</a>		
	<%}%>
	<%for (int i = startPage; i<=endPage; i++){
		if (i == currentPage){ // 동일한페이지면 링크 x, b태그로
		out.print("<b>["+i+"]</b>");
		} else {
			out.print("<a href ='ex4_listProduct_paging.jsp?pageNum="+i+"'>[" + i + "]</a>");
		}		
	}
	if (endPage < pageCnt){%>
		<a href = "ex4_listProduct_paging.jsp?pageNum=<%=endPage+1%>">[다음]</a>
	<%}%>	
	</div>
</body>
</html>