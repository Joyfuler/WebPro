<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>  
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#home{
color: lightblue;
cursor: pointer; 
}
</style>
<script>
console.log('예외 메시지: <%=exception.getMessage()%>');
console.log('예외 타입 : <%=exception.getClass().getName()%>');
</script>
</head>
<body>
	<h3>사이트를 이용해주셔서 감사합니다.<br>
	죄송하지만, 현재 요청하신 URL을 찾을 수 없습니다.<br>
	<span id = "home" onclick = 'location.href="<%=conPath%>/input.html"'>HOME</span>에서 다시 한번 접속해주세요.(error code: 500)
	</h3>
	<% System.out.println("예외 메시지 : " + exception.getMessage()); 
	   System.out.println("예외 타입 : " + exception.getClass().getName());
	%>
</body>
</html>