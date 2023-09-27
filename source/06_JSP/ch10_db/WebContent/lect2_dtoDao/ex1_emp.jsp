<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.lec.dto.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table>
		<%
			EmpDao eDao = EmpDao.getInstance();
		ArrayList<EmpDto> empList = eDao.EmpList(); // dao의 empList함수에 있는 sql 등등을 모두 실행
		if (empList.isEmpty()) { // size가 0이어서 비어있는 경우
			out.println("<tr><td>입력된 데이터가 없습니다.");
		} else {
			out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번"
			+ "</th><th colspan='3'>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
			for (EmpDto emp : empList) { // 타입 새변수이름 : 기존배열
				out.println("<tr><td>" + emp.getEmpno() + "</td><td>" + emp.getEname() + "</td><td>" + emp.getJob()
				+ "</td><td>" + (emp.getMgr() == 0 ? "없음" : emp.getMgr()) + "</td><td colspan='3'>" + emp.getHiredate()
				+ "</td><td>" + emp.getSal() + "</td><td>" + emp.getComm() + "</td><td>" + emp.getDeptno()
				+ "</td></tr>");
			}
		}
		%>
	</table>
</body>
</html>