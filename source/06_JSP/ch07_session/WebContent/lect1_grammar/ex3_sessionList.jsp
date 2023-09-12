<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
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
	//세션의 모든 값을 리스트로 반환
	out.println("<h1> 모든 세션 속성들 </h1>");
	Enumeration<String> sAttrNames = session.getAttributeNames(); // String의 enumaration으로 반환되므로, 
	// sAttrNames의 속성을 이에 맞춰 지정해줌
	int cnt = 0;
	while (sAttrNames.hasMoreElements()){ //세션의 다음 속성값이 있는 동안 반복.
		cnt++;
		String sname = sAttrNames.nextElement(); //처음부터 끝까지 속성값의 이름 출력
		String svalue = session.getAttribute(sname).toString();  //위 속성값의 이름의 값을 출력
		out.println("<h2>" + cnt + "." + sname + "(세션속성이름):" + svalue + "(세션값)</h2>");
	}
	if (cnt ==0){
		out.println("<h2>세션 내 데이터가 없습니다.");
	}
	
	%>
	<h2> 세션 ID : <%=session.getId() %></h2>
	<h2> 세션 유효시간: <%=session.getMaxInactiveInterval() %></h2>
	<!-- 해당 시간이 지나면 자동으로 세션이 사라짐. 즉 로그아웃 -->
	<hr>
	<a href ="ex1_sessionAddAttr.jsp">세션 데이터 추가</a><br>
	<a href = "ex2_sessionGet.jsp">특정 세션 가져오기 </a><br>
	<a href = "ex3_sessionList.jsp">세션의 모든 데이터를 가져오는 방법</a><br>
	<a href = "ex4_sessionRemove.jsp">세션 제거하기</a><br>
	
	
</body>
</html>