<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
<script>
	setTimeout(() => {
		location.href='main.jsp';
	}, 1000);
</script>
</head>
<body>
<%
// 세션을 지우고 메인으로 보내면 끝.
// session.invalidate();
// response.sendRedirect("main.jsp");

if (session.getAttribute("member")!= null){
	session.invalidate();
	out.print("<h2>로그아웃 되었습니다. 잠시 후 메인 페이지로 이동합니다.");
} else {
	out.print("<h2>로그인 상태가 아닙니다. 잠시 후 메인 페이지로 이동합니다.");
}
%>
</body>
</html>