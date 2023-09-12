<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<link href="<%=conPath%>/css/ex4.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int su; %>
	<%
	String suParam = request.getParameter("num"); 
	if (suParam != null){
		su = Integer.parseInt(suParam);
		Random random = new Random();
		int computerSu = random.nextInt(3)+1;
		session.setAttribute("correctAnswer", computerSu);
		Integer correctAnswer = (Integer) session.getAttribute("correctAnswer");
	

		if (su != computerSu){
			String msg = "<h2> Wrong! Try Again!</h2>";
			msg = URLEncoder.encode(msg,"utf-8");
			response.sendRedirect("ex4_yaba.jsp?msg="+msg);
		}
	} else {
		response.sendRedirect("ex4_yaba.jsp");
	}
	
	
	%>
	<div id = "wrap">
	<h2>정답입니다.</h2>
	<h3>동전이 있던 곳은 <%=su %></h3>
	<button onclick ="location.href='ex4_yaba.jsp'">다시도전</button>
	</div>
</body>
</html>