<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/header.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<header>
	<div id = "nav">
	<ul>
	<% 
	String name = (String)session.getAttribute("name"); // 회원가입 성공한 경우, id와 pw의 세션을 지웠기 때문에
	if (name == null){%> <%--비로그인시의 헤더화면 --%>
	<li><a href = "<%=conPath%>/member/join.jsp">회원가입</a></li>
	<li><a href = "<%=conPath%>/member/login.jsp">로그인</a></li>
	<li><a href = "<%=conPath%>/">홈</a></li>
	
		
	<%} else { %> <%-- 로그인시의 헤더화면 --%>
	<li><a href = "<%=conPath%>/member/logout.jsp">로그아웃</a></li>
	<li><a href = "<%=conPath%>/member/sessionList.jsp">세션 리스트</a></li>
	<li><a href = "<%=conPath%>/"><%=name%> 님</a></li>
	<% }%>
	
	
	</ul>
	</div>
	</header>
</body>
</html>