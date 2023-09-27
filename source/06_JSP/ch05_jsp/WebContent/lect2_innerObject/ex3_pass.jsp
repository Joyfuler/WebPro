<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>(ageInput.html에서 나이입력) -> (agePro.jsp(나이에 따른 분기)) ->
		pass.jsp?age='age'</h2>
	<!--  여기서 뒤로가기를 누르면 agePro가 아닌 ageInput으로 돌아감. 브라우저에서는 jsp를 거치지 않았기 때문 -->
	<%
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h2>
		<%=age%>살은 성인으로 주류 구매 가능합니다.
	</h2>
	<button onclick="history.go(-1)">뒤로가기</button>
	<button onclick="location.href='ex3_ageInput.html'">새로 입력</button>
</body>
</html>