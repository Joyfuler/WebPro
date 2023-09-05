<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
	button{
	display:inline-flex;
	background: linear-gradient( 45deg, darkblue, skyblue );
	color: white;
	border: 1px solid navy;
	margin: 5px;
	}
	</style>
</head>
<body>

	<%! String name,id,pw; %>
	
	<% 
	request.setCharacterEncoding("utf-8"); // 한글의 경우 깨짐 현상이 발생하니, 인코딩을 utf-8로 바꾸는 작업을 거침.
	name = request.getParameter("name"); 
	 id = request.getParameter("id"); 
	 pw = request.getParameter("pw"); %>
	
	<h3> 아이디는 <%=id%>이고,</h3> 
	<!--  식이나 변수를 삽입하는 용도 -->
	<h3> 비밀번호는 <%=pw%>입니다.</h3>
	<h3> 어서오세요, <%=name%> 님!</h3>
	<hr>
	<button onclick = "history.back()"> 뒤로 가기 </button><button onclick = "location.href='6_login.jsp'">로그인</button>
	
</body>
</html>