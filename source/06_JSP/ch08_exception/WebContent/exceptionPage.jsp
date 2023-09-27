<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<%-- ex2.jsp에서 예외발생 시 오는 페이지 --%>
<%@ page isErrorPage="true"%>
<%
	response.setStatus(200);
%>
<!-- 
200: 정상상태 / 404 : 해당 문서 찾지 못함 / 500 : 문법오류 / 예외발생
400,407 : 

 -->
<!DOCTYPE html>
<html>
<head>
<style>
#home {
	color: lightblue;
	cursor: pointer;
}
</style>

<script>
console.log('예외 메시지: <%=exception.getMessage()%>');
console.log('예외 타입 : <%=exception.getClass().getName()%>
	');
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/이름을변경하세요.css" rel="stylesheet"
	type="text/css"
>
</head>
<body>
	<h3>
		언제나 사이트를 이용해주셔서 감사합니다.<br> 죄송하지만, 현재 요청하신 URL을 찾을 수 없습니다.<br>
		<span id="home" onclick='location.href="<%=conPath%>/input.html"'>HOME</span>에서
		다시 한번 접속해주세요.
	</h3>
	<%
		System.out.println("예외 메시지 : " + exception.getMessage());
	System.out.println("예외 타입 : " + exception.getClass().getName());
	%>
</body>
</html>