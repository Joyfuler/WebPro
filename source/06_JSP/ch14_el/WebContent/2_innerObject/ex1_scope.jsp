<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String conPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="ex2_scope.jsp">
		<p>
			ID <input type="text" name="id">
		</p>
		<p>
			PW <input type="text" name="pw">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<%
	pageContext.setAttribute("pageName", "pageValue");
	request.setAttribute("requestName", "requestValue");
	session.setAttribute("sessionName", "sessionValue");
	application.setAttribute("appName", "appValue");
	RequestDispatcher dispatcher = request.getRequestDispatcher("ex2_scope.jsp?id=홍길동&pw=111");
	dispatcher.forward(request, response);
	//forward할 객체 생성
	%>



	<%--<jsp:forward page="ex2_scope.jsp"></jsp:forward>--%>
	<h3>
		페이지 내 attribute :
		<%=pageContext.getAttribute("pageName")%></h3>
	<h3>페이지 내 attribute : ${pageScope.pageName }</h3>
	<h3>
		request 내 attribute :
		<%=request.getAttribute("requestName")%></h3>
	<h3>request 내 attribute : ${requestScope.requestName }</h3>
	<h3>
		session 내 attribute :
		<%=session.getAttribute("sessionName")%></h3>
	<h3>session 내 attribute : ${sessionScope.sessionName }</h3>
	<h3>
		application 내 attribute :
		<%=application.getAttribute("appName")%></h3>
	<h3>application 내 attribute : ${applicationScope.appName }</h3>

	<%--scope를생략해도 무방 --%>
	<h3>페이지 내 attribute : ${pageName }</h3>
	<h3>request 내 attribute : ${requestName }</h3>
	<h3>session 내 attribute : ${sessionName }</h3>
	<h3>application 내 attribute : ${appName }</h3>

</body>
</html>