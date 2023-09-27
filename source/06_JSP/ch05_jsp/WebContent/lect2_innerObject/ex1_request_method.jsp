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
	<%-- 255.255.0.1(내 서버 가상주소) IPv4 -> IPv6 --%>
	<%-- jsp에서는 RequestHTTPServlet등의 변수를 선언하지  않아도 사용이 가능함.--%>
	<h2>
		요청한 곳의 주소: ★
		<%=request.getRemoteAddr()%></h2>
	<h2>컨텍스트 root : ch05_jsp</h2>
	<h2>
		컨텍스트path ★ : /ch05_jsp //
		<%=request.getContextPath()%>
	</h2>
	<h2>
		세션 객체 :
		<%=request.getSession()%></h2>
	<h2>
		요청 URL :
		<%=request.getRequestURL()%></h2>
	<h2>
		요청 URI :
		<%=request.getRequestURI()%></h2>
	<h2>
		해당 프로토콜:
		<%=request.getProtocol()%></h2>
	<h2>
		포트 번호:
		<%=request.getServerPort()%></h2>
	<!--  css에서 링크를 거는 경우에는 /ch05_jsp/css/ex.css 등으로 입력하면, /ch05_jsp앞에 내 호스트 번호로 된 주소가 생략된 것. -->
	<!--  form에서 액션을 걸 때도 -->
</body>
</html>