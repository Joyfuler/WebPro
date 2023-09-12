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
	Enumeration<String> sAttrNames = session.getAttributeNames();	
	// 브라우저에 있는 session값을 모두 받아옴
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
	<button onclick = "history.back()"> 이전페이지</button>
	<button onclick = "location.href='<%=conPath%>/lect2_login/login.jsp'">로그인</button>
	<button onclick = "location.href='<%=conPath%>/lect2_login/logout.jsp'">로그아웃</button>
	<button onclick = "location.href='<%=conPath%>/lect2_login/welcome.jsp'">메인페이지</button>
	<button onclick = "location.href='<%=conPath%>/lect2_login/sessionList.jsp'">세션들여다보기</button>
	
</body>
</html>