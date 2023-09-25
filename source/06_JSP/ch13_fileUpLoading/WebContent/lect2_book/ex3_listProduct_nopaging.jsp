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
BookDao bDao = BookDao.getInstance();
ArrayList<BookDto> books = bDao.listBook();
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
</body>
</html>