<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/style.css" rel = "stylesheet">
<style>
		#content {
			width: 800px; height:350px;
			margin: 50px auto;
		}
	</style>
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function(){
		$('#datepicker').datepicker({
			dateForamt : 'yy-mm-dd',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토'],
			showMonthAfterYear : true,
			showOtherMonths : true,
			selectOtherMonths : true,
			yearSuffix : '년',
		});
	});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<c:if test = "${empty member}">
		<script>
			alert("로그인 후 책 등록이 가능합니다.");
			location.href='${conPath}/member/login.do?after=book/bookRegister.do';
		</script>
	</c:if>
	<c:if test = "${not empty param.loginResult }">
		<script>
			alert('${param.loginResult}');
		</script>
	</c:if>
	<form action = "${conPath }/book/bookRegister.do" method = "post" enctype = "multipart/form-data">
	<table>
		<caption> 책등록하기</caption>
	<tr>
		<td>
			책이름 : <input type = "text" name = "btitle">
		</td>
	</tr>
	<tr>	 
		<td>
			작가명 : <input type = "text" name = "bwriter">			
		</td>
	</tr>
	<tr>	
		<td>	
			출판일: <input type = "date" name = "brdate" id = "datepicker">
		</td>
	</tr>
	<tr>	
		<td>	
			책표지: <input type = "file" name = "tempbimg1">
		</td>
	</tr>
	<tr>	
		<td>	
			책표지2: <input type = "file" name = "tempbimg2">
		</td>
	</tr>
	<tr>		
		<td>
			책소개: <input type = "text" name = "binfo">			
		</td>
	</tr>	
	<tr>
		<td colspan ="2">
			<input type = "submit" value = "등록">
		</td>
	</tr>	
	</table>
	</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>