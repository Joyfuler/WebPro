<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 표현식 태그 이용</h2>
	<p> 산술연산자: 10+1 =  <%=10+1%></p>
	<p> 산술연산자 : 10/0.0 = <%=10/0.0%></p>
	<p> 관계연산자 : 1>2 = <%=1>2%></p>
	<p> 관계연산자: 1==2 = <%=1==2%></p>
	<p> 조건연산자: <%=(1>2) ? "1이 더 큽니다" : "1이 크지 않습니다" %></p>
	<p> 로그인 여부: <%=session.getAttribute("customer") == null ? "로그인 안함" : "로그인함"%></p>
	<p> 로그인 여부: <%=session.getAttribute("customer") != null ? "로그인 함" : "로그인 안함"%></p>
	<p> pageNum 패러미터 여부 : <%=request.getParameter("pageNum") == null? "패러미터 없음": "패러미터 있음" %>
	<p> name 패러미터 값 : <%=request.getParameter("name")%></p>
	<%--<p> name 패러미터 대문자 변경 : <%=request.getParameter("name").toUpperCase()%></p>--%>
	
	<h2> EL 표기법 (표현식 안에 쓸 수 있는 모든 연산자 다 사용가능)</h2>
	<p> 산술연산자: 10 + 1 = ${10+1 }</p>
	<p> 산술연산자 : 10/0.0 = ${10/0.0 }</p>
	<p> 관계연산자 : 1>2 = ${1>2 }</p>
	<p> 관계연산자: 1==2 = ${1 eq 2 }</p>
	<p> 관계연산자: 1!=2 = ${1 != 2 }</p>
	<p> 조건연산자: ${(1>2) ? "1이 더 큽니다" : "1이 크지 않습니다" }</p>
	<p> 로그인 여부: ${customer eq null ? "로그인 안함" : "로그인함" }</p>
	<p> 로그인 여부: ${empty customer ? "로그인 안함" : "로그인함" }</p>
	<p> 로그인 여부: ${not empty customer ? "로그인함" : "로그인 안함" }</p>
	<p> pageNum 패러미터 여부: ${empty param.pageNum ? "패러미터 없음 " : "패러미터 있음" }</p>	
	<p> name 패러미터 값 : ${param.name }</p>
	<p> name 패러미터 대문자 변경 : ${param.name.toUpperCase() }</p>
</body>
</html>