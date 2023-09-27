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
<%
	String name = (String) session.getAttribute("name");
if (name != null) { // 세션 중 name에 값이 있는 경우 = 로그인 상태
	//session.removeAttribute("name");
	//session.removeAttribute("id");
	session.invalidate(); // 세션값을 모두 삭제
	out.println("<h1> 로그아웃 성공</h1>");
} else { // 이미 로그아웃 상태인 경우
	out.println("<h1>이미 로그아웃된 상태입니다</h1>");
}
%>

</head>
<body>
	<button onclick="location.href='<%=conPath%>/lect2_login/login.jsp'">로그인</button>
	<button onclick="location.href='<%=conPath%>/lect2_login/welcome.jsp'">메인페이지</button>
	<button
		onclick="location.href='<%=conPath%>/lect2_login/sessionList.jsp'"
	>세션들여다보기</button>
</body>
</html>