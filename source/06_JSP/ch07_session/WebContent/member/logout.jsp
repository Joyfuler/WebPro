<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/main.css" rel="stylesheet" type="text/css">
<script>
	var second = 3;
	window.onload = function(){
	let id = setInterval(() => {
		if (second > 0){
			second--;
			document.getElementById("countDown").innerHTML = second + "초";
		} else {	
			location.href = "../member/main.jsp";
		}
	}, 1000)};
	setTimeout(() => {
		clearInterval(id);
	}, 2000);
	</script>
</head>
<body>
	<%
		String name = (String) session.getAttribute("name");
	if (name != null) {
		session.invalidate(); 
		%>
		<jsp:include page="../member/header.jsp" />	
		<div id = "mainForm_wrap">로그아웃 성공. <span id ="countDown">3초 </span> 후 메인으로 이동합니다</div>
		<%
	}else { 
	%>
	<jsp:include page="../member/header.jsp" />		
	<div id = "mainForm_wrap">로그아웃 성공. <span id ="countDown">3초 </span> 후 메인으로 이동합니다</div>	
	<%
		}
	%>	
	<jsp:include page="../member/footer.jsp"></jsp:include>
</body>
</html>