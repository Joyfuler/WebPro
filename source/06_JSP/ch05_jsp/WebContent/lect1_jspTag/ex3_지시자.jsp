<%@page import="java.util.Arrays"%>
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
	<%-- 지시자(<%@ %> : page, include, taglib--%>
	<h2>모든 페이지에 header등을 붙인다면 include는 필수</h2>
	<%
		int[] arr = { 10, 20, 30 };
	out.println(Arrays.toString(arr));
	%>
	<hr>
	<%@ include file="../main/footer.jsp"%>
	<%-- include를 통해 외부 파일 내용을 그대로 불러올 수 있음. --%>
	<hr>
	다시 ex3_지시자.jsp 페이지입니다.
</body>
</html>