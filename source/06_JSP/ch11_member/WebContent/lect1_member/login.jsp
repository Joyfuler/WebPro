<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<%
	if (session.getAttribute("member") != null) { // 로그인해서 세션이 있는 상태
	// 이 member 객체의 값은 loginOk에서 가져올 것. 없다면(로그인이 안되었다면) 로그인을 진행, 있다면 (로그인 상태라면) 메인페이지로 이동함.
	response.sendRedirect("main.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="loginOk.jsp" method="post">
		<!--  비로그인상태에서 회원정보 수정을 하면, 먼저 로그인한 후 회원정보 수정 페이지로 이동할 수 있도록 -->
		<input type="text" name="method"
			value="<%=request.getParameter("method")%>"
		>
		<table>
			<caption>로그인</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" required="required"
					value="<%String id = (String) session.getAttribute("id");
					out.print(id != null ? id : "");%>"
				></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"> 
				<input type="button" value="회원가입" onclick='location.href="join.jsp"'>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>