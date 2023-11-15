<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/style.css" rel = "stylesheet">
<style>
	#content {width: 800px; height:350px;margin: 50px auto; }
	img{width: 100px;}
	a {text-decoration: none; color:black;}
	b {color:red;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<script>
	$(document).ready(function(){
		
	});
</script>
</head>
<body style = "text-align: center;">
<c:set var = "SUCCESS" value = "1"/>
<c:if test = "${registerResult eq SUCCESS }">
	<script>
		alert("책 등록이 완료되었습니다.");
	</script>
</c:if>	
<c:if test = "${not empty deleteResult }">
	<script>
		alert('해당 책 데이터가 삭제되었습니다.');		
	</script>
</c:if>	
	<jsp:include page="../main/header.jsp"/>
	<br><br><br>
	<form action ="">
		<select name = "schItem">			
			<option value = "btitle" 
			<c:if test = "${param.schItem eq btitle }">
			selected = "selected"
			</c:if>
			>책제목</option>
			<option value = "bwriter"
			<c:if test = "${param.schItem eq bwriter }">
			selected = "selected"
			</c:if>
			>저자명</option>
			<option value = "all"
			<c:if test = "${param.schItem eq all }">
			selected = "selected"
			</c:if>			
			>책제목+저자명</option>
		</select>
		<input type = "text" name = "schWord" value = "${param.schWord }"><input type = "submit" value = "검색"> 
	</form>
	
	<div id = "content">
		<table>
			<caption> 도서 LIST </caption>
			<tr>
			<c:forEach var = "books" items = "${bookList }">
				<td onclick = "location.href='${conPath}/book/bookDetail.do?bnum=${books.bnum}&pageNum=${paging.currentPage}'">			
				${books.bnum } / ${books.btitle } / <br>
				<img src = "${conPath }/bookImgFileUpload/${books.bimg1}"><br>
				${books.bwriter } <br>
				출판일 : ${books.brdate } <br>	  
				</td>				
				</c:forEach>
			</tr>
		</table>
			<div>
				<c:if test = "${paging.startPage>paging.blockSize }">
				<a href = "${conPath }/book/bookList.do?pageNum=${paging.startPage -1}&schItem=${param.schItem}&schWord=${param.schWord}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
					<c:if test = "${paging.currentPage eq i }">
						<b>[${i }]</b>
					</c:if>
					<c:if test = "${paging.currentPage != i }">
						<a href = "${conPath }/book/bookList.do?pageNum=${i}&schItem=${param.schItem}&schWord=${param.schWord}">[${i }]</a>
					</c:if>
				</c:forEach>
				<c:if test = "${paging.endPage <paging.pageCnt}">			
					<a href = "${conPath }/book/bookList.do?pageNum=${paging.endPage +1 }&schItem=${param.schItem}&schWord=${param.schWord}">[다음]</a>
				</c:if>				
			</div>
		</div>		
	<jsp:include page = "../main/footer.jsp"/>
</body>
</html>