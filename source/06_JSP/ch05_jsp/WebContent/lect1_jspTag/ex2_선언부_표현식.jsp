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
	<!--  HTML 주석 -->
	<%-- JSP 주석 --%>

	<%
		//스크립트릿 내의 자바 주석
	%>
	3가지 주석 중, 웹브라우저에서 실제로 실행했을 때 남는 주석은 HTML뿐임. (F12 - Source를 통해 확인)
	<br>


	<%!String name;

	/* private String Student() {
		return "홍길동";
	} */%>

	<%
		int j = 0;
	String localStr = "몰라요";
	i++;
	j++;
	globalStr += "<span>★</span>";
	out.println("전역변수 i=" + i + "<br>");
	out.println("지역변수 j=" + j + "<br>");
	out.println("전역변수 globalStr = " + globalStr + "<br>");
	out.println("지역변수 localStr = " + localStr + "<br>");
	%>

	<%!int i;
	int k;
	String globalStr = "Good";%>
	<%-- jsp는 선언부가 먼저 실행되므로, 윗쪽에 k++등을 입력해도 숫자가 증가함. --%>

</body>
</html>