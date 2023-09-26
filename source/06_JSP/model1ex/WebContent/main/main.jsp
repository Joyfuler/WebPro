<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href = "<%=conPath%>/css/style.css" rel = "stylesheet">
	<style>
		#mainForm_wrap{
			width:1000px; margin: 10px auto; height: 600px; 
			border: 1px solid #005500;
			line-height: 600px;
			text-align: center;
			font-size: 3em; color: #005500;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		어서오세요. 메인화면입니다
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>