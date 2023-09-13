<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<!-- 프로세스단 -->
<jsp:useBean id="person" class = "com.lec.ex.Person" scope = "request"/>
<jsp:setProperty name="person" property="name" value ='<%=request.getParameter("name")%>'/>
<jsp:setProperty name="person" property="age" value ='<%=Integer.parseInt(request.getParameter("age"))%>'/>
<jsp:setProperty name="person" property="gender" value ='<%=request.getParameter("gender").charAt(0) %>'/>
<jsp:setProperty name="person" property="address" value ='<%=request.getParameter("address")%>'/>
<jsp:forward page="personView.jsp"></jsp:forward>
</body>
</html>