<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<%
	String name = (String)session.getAttribute("name"); //형변환!
	String id = (String)session.getAttribute("id");%> 
	
	<%if (name != null){%> <%--name 값이 있음. 즉 로그인된 상태 --%>
		<h1><%=name%>(<%=id%>)님 안녕하세요</h1>
		<button onclick = "location.href='<%=conPath%>/lect2_login/logout.jsp'">로그아웃</button>
				
		
	<%} else { %> <%-- name값이 없음. 즉 로그인 안 된 상태 --%>
		<h1>손님, 안녕하세요. 로그인이 필요합니다.</h1>
		<button onclick = "location.href='<%=conPath%>/lect2_login/login.jsp'">로그인</button>
	<%}%>
		<button onclick = "location.href='<%=conPath%>/lect2_login/sessionList.jsp'">세션들여다보기</button>
		<!-- 세션들여다보기는 로그인/로그아웃과 상관없이 모두 출력되므로 if구문 바깥으로 뺌. -->
</body>
</html>