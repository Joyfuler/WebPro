<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.lec.dto.DeptDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.DeptDao"%>
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
	<form action = "ex2_empOut.jsp">
	<p> 
		부서번호 <select name = "deptno">
		<option value = "0"></option>
		<%
		DeptDao dDao = DeptDao.getInstance();
		ArrayList<DeptDto> deptList = dDao.deptList();
		//제대로 들어왔는지 확인하고 싶다면 deptList.size() 를 통해 제대로 들어왔는지를 확인
		for (DeptDto dept : deptList){
			// <option value = '1'>10-SALES-NEW YORK</option>
			int deptno = dept.getDetpno();
			String dname = dept.getDname();
			String loc = dept.getLoc();			
			out.println("<option value ='"+deptno+"'>"+deptno+"-"+dname+"-"+loc+"</option>");
		}		
		%>
		</select>		
		<input type = "submit" value = "검색" class = "btn">
	</p>
	</form>
</body>
</html>