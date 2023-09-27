<%@page import="com.lec.ex.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>특정 세션 값 가져오기</h1>
	<%
		// 특정 세션 값 가져오는 방법
	String sessionName = (String) session.getAttribute("sessionName");
	Integer sessionNum = (Integer) session.getAttribute("sessionNum");
	Member member = (Member) session.getAttribute("member");
	// getAtrribute는 object를 리턴하므로, 타입을 맞추기 위해 형변환을 해준다.
	String noSessionAttr = (String) session.getAttribute("noSessionAttr");
	out.println("<h2>sessionName =" + sessionName + "<h2>");
	out.println("<h2>sessionNum =" + sessionNum + "<h2>");
	if (member != null) {
		out.println("<h2>member안의 id : " + member.getId() + "</h2>");
		out.println("<h2>member안의 pw : " + member.getPw() + "</h2>");
		out.println("<h2>member안의 name : " + member.getName() + "</h2>");

	} else {
		out.print("<h2>세션에 member속성이 없습니다</h2>");
	}
	%>
	<h2>
		세션에 추가하지 않은 데이터 (noSessionAttr):
		<%=noSessionAttr%></h2>
	<h2>
		세션 ID :
		<%=session.getId()%></h2>
	<h2>
		세션 유효시간:
		<%=session.getMaxInactiveInterval()%></h2>
	<!-- 해당 시간이 지나면 자동으로 세션이 사라짐. 즉 로그아웃 -->
	<hr>
	<a href="ex1_sessionAddAttr.jsp">세션 데이터 추가</a>
	<br>
	<a href="ex2_sessionGet.jsp">특정 세션 가져오기 </a>
	<br>
	<a href="ex3_sessionList.jsp">세션의 모든 데이터를 가져오는 방법</a>
	<br>
	<a href="ex4_sessionRemove.jsp">세션 제거하기</a>
	<br>
</body>
</html>