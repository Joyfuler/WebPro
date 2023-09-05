<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	//자바 소스를 입력하는 부분
	%>
	<p> 2의 3승은 <%=power(2,3)%> 입니다.</p>
	<p> 9의 10승은 <%=power(9,10)%> 입니다.</p>
	<%-- 주석 --%>	
	
	<%!
		public long power(int a, int b){ //a의 b승을 return.
		long result = 1;
		for (int i =0; i<b; i++){
			result = result * a; // result *= a
		}
		return result;
	}
	 %>
	 <%-- <%!는 선언부. 맨 처음에 수행됨.(일반적으로 위에서 아래로). 자바스크립트 역시 함수를 먼저 해석하는 것과 같음. 
	 변수나 메소드를 선언할 때 선언부를 만들고 그곳에 넣자.--%>
</body>
</html>