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
			String deptnoStr = request.getParameter("deptno");
		if (deptnoStr == null) {
			deptnoStr = "0";
		}
		int deptnoInput = Integer.parseInt(deptnoStr);
		// dao를 가져오는 작업
		EmpDao eDao = EmpDao.getInstance(); // 출력을위한 empdao의 기능들을 가져옴.
		ArrayList<EmpDto> empList = eDao.deptnoEmpList(deptnoInput); // deptnoInput 매개변수를 넣어주므로 매개변수를 받아주는 EmpDto를 가져옴
		// empList 출력하기
		out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>부서번호</th></tr>");
		if (empList.size() == 0) {
			out.print("<tr><td colspan='4'>사람이 없습니다</td></tr>");
		} else {
			for (int idx = 0; idx < empList.size(); idx++) {
				out.print("<tr><td>" + empList.get(idx).getEmpno() + "</td>" // arrayList는 [idx]가 아닌 get(idx)로 가져와야 함!
				+ "<td>" + empList.get(idx).getEname() + "</td>" + "<td>" + empList.get(idx).getJob() + "</td>" + "<td>"
				+ empList.get(idx).getDeptno() + "</td>");
			}
			out.print("<tr><td colspan='4'>이상 총" + empList.size() + "명</td></tr>");
		}
		%>
	</table>
</body>
</html>