<%@page import="java.util.Enumeration"%>
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
	<%
		// 세션1개씩삭제 (로그아웃시 사용)		
	session.removeAttribute("sessionName");
	Enumeration<String> sAttrNames = session.getAttributeNames(); //모든세션가져오기
	int cnt = 0;
	while (sAttrNames.hasMoreElements()) {
		String sname = sAttrNames.nextElement();
		String svalue = session.getAttribute(sname).toString();
		out.println("<h2>" + cnt + "." + sname + "(세션속성이름):" + svalue + "(세션값)</h2>");
	}
	if (cnt == 0) {
		out.println("<h2>세션 내 데이터가 없습니다.");
	}

	// 모든 섹션 삭제하기
	session.invalidate(); // setAttribute() 했던 모든 세션 속성을 다 제거.setAttribute시 세션 ID가 새로 생김.
	if (request.isRequestedSessionIdValid()) { // 만일 요청한 세션 id가 있다면(valid)	
		out.println("<h3>유효한 세션 ID가 있습니다.</h3>");
	} else {
		out.println("<h3>유효한 세션 ID가 없습니다.</h3>"); // invalid
	}
	%>

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