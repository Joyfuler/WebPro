<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/이름을변경하세요.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	// 넘어올 때는 String이므로 Integer 형변환 꼭!
	int num2 = Integer.parseInt(request.getParameter("num2"));
	out.println("<h2> num1 = " + num1 + "</h2>");
	out.println("<h2> num2 = " + num2 + "</h2>");
	out.println("<h2> num1+ num2 = " + (num1+num2) + "</h2>");
	out.println("<h2> num1* num2 = " + (num1*num2) + "</h2>");
	out.println("<h2> num1- num2 = " + (num1-num2) + "</h2>");
	try{
	out.println("<h2> num1/ num2 = " + (num1/num2) + "</h2>");
	} catch (Exception e){
		out.println("<h2>0으로 나누면 에러가 발생할수 있습니다 </h2>");
		System.out.println(e.getMessage());
		%>
		<script>
		console.log('<%=e.getMessage()%>');
		</script>
		<%}%>
</body>
</html>