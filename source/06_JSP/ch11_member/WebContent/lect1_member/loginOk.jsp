<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
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
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
String id = request.getParameter("id"); // login.jsp에서 입력했던 아이디와 비밀번호를 받아옴
String pw = request.getParameter("pw");
String method = request.getParameter("method"); // input에서 hidden으로 가리는 method. null 또는 modify
MemberDao mDao = MemberDao.getInstance(); // db에 있는 기능을 불러와서, 입력한 아이디와 비밀번호가 db와 일치하는지 확인함.
int result = mDao.loginCheck(id, pw);
if (result == MemberDao.LOGIN_SUCCESS){ // 로그인에 성공하면 session에 member를 넣는다
	MemberDto member = mDao.getMember(id); // dto에서 id를 이용해 해당 멤버의 정보들을 객체로 가져온다.
	session.setAttribute("member", member);
	if (method.equals("null")){ // 로그인하지 않았다면 main으로
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect(method+".jsp");
	}	
} else if (result == MemberDao.LOGIN_FAIL_PW){
%>
	<script>
	alert("비밀번호 확인");
	history.back();
	</script>	
	
<%
			} else if (result == MemberDao.LOGIN_FAIL_ID){
		%>
	<script>
	alert("아이디 확인");
	location.href='login.jsp';
	</script>	

<%}%>
</body>
</html>