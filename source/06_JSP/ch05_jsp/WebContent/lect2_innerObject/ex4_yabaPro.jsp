<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String conPath = request.getContextPath();
%>

<%!String numParam;
	int num = 0;%>
<%
	numParam = request.getParameter("num");
if (numParam != null) {
	num = Integer.parseInt(numParam);
	// 컴퓨터 발생 난수를 비교 분기 or 머무르거나 돌아가기
	//int comNum = (int)(Math.random()*3)+1; // 결국 int로 형변환해야하므로 math.floor를 사용하지 말고 int 형변환만 하자
	Random random = new Random();
	int comNum = random.nextInt(3) + 1; // 혹은 random.nextInt를 통해 1,2,3 난수를 발생시킴
	if (num != comNum) {
		String msg = "<h2>Wrong! Try Again!  </h2>" +	
	"<h2>" + num + "은 틀린 번호입니다. 정답은" + comNum + "<h2>";
		msg = URLEncoder.encode(msg,"utf-8"); // 한글 파라미터를 넘기기 위한 작업. (자바스크립트) 
		response.sendRedirect("ex4_yaba.jsp?msg=" + msg); // 메시지 패러미터를 다시 yaba.jsp로 되돌림.
	}

} else {
	response.sendRedirect("ex4_yaba.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<link href="<%=conPath%>/css/ex4.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "wrap">
	<h2>정답입니다.</h2>
	<h3>동전이 있던 곳은 <%=num %></h3>
	<button onclick ="location.href='ex4_yaba.jsp'">다시도전</button>
	</div>
</body>
</html>