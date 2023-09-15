<%@page import="com.lec.dto.EmpDto"%>
<%@page import="com.lec.dao.EmpDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dto.DeptDto"%>
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
<form action = "">
<p>
부서번호 <select name = "deptno">
<option value = "0">모든 부서</option>
<%
// 이용자가 선택한 deptno
String deptnoStr = request.getParameter("deptno");
if (deptnoStr==null){ // 처음에는 아무것도 선택되지 않은 상태이므로 이 값을 미리 조정해준다
	deptnoStr = "0";	
} 
int deptnoInput = Integer.parseInt(deptnoStr);
//db에서 option value가 될 deptno를 받아야 함. 또한 사용자가 선택한 deptno와 일치한 경우 selected를 걸어야 함.
DeptDao dDao = DeptDao.getInstance();
ArrayList<DeptDto> depts = dDao.deptList(); // deptList 함수 안 쿼리에 해당하는 3가지 테이블 값을 가져옴.
for (DeptDto dept : depts){ //확장for문. 타입  변수이름 : 배열
	//<option value = '10'>10-SALES-BOSTON</option> or
	// <option value = '10' selected = 'selected'>10-SALES-BOSTON</option>
	int deptno = dept.getDetpno();
	String dname = dept.getDname();
	String loc = dept.getLoc();
	if (deptnoInput ==deptno){
		out.print("<option value = '"+deptno+"' selected = 'selected'>"+deptno+"-"+dname+"-"+loc+"</option>");
	}else{
		out.print("<option value = '"+deptno+"'>"+deptno+"-"+dname+"-"+loc+"</option>");
	}
	
}

%>
</select>
<input type = "submit" value = "검색">
</p>
</form>
<table>
	<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th><th>부서명</th></tr>
	<% // 부서번호입력시 dname을 포함한 직원리스트
	EmpDao eDao = EmpDao.getInstance();
	ArrayList<EmpDto> emps = eDao.dnameEmpList(deptnoInput);
	if (emps.isEmpty()){
		out.println("<tr><td colspan='5'>사람이 없습니다</td></tr>");
	} else {
		for (EmpDto emp : emps) {
			out.println("<tr><td>"+emp.getEmpno()+"</td><td>"+emp.getEname()+"</td><td>"
					+emp.getHiredate()+"</td><td>"+emp.getDeptno()+"</td><td>"+
					emp.getDname()+"</td></tr>");
		}
		out.print("<tr><td colspan='5'>총 " + emps.size() + "명</td></tr>");
	}
	%>
	
</table>
</body>
</html>