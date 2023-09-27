<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<form action = "">
	<table>	
	<input type = "number" name = "a" value = "<%=(int)(Math.random()*9)+1 %>" readonly="readonly"> * <input type = "number" name = "b" value = "<%=(int)(Math.random()*9)+1%>" readonly="readonly"> = <input type = "number" name = "c"> <br>
	<input type = "submit" value = "확인">	
	${param.a } * ${param.b } = ${param.c } 는  
	${param.a*param.b eq param.c ? "true 정답": "false" }
	${not empty param.result ? (param.n1*param.n2 eq param.result ? "정답":"오답") : "" }
	
	</table>
	</form>
</body>
</html>