<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/main/css/intro.css" rel = "stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class = "top_title">
		<h1 class = "title"> 
		More Fun, More Games 
		</h1>
	</div>
	<div class = "bottom">
	<section>
		<h2>CONTACT
		<span>-문의사항-</span>
		</h2>		
	</section>	
	<p> 사이트에 대한 문의사항은 아래 문의 페이지를 통해 문의해주세요. 빠른 시일 내로 답변해 드리겠습니다. </p> 
		<div class = "bottom_btn"><a href="${conPath }/board/list.jsp?bid=qna"> ▶문의게시판</a>
		</div>
	</div>
<jsp:include page="footer.html"/>
</body>
</html>