<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<%!String driver = "oracle.jdbc.driver.OracleDriver";
String url    = "jdbc:oracle:thin:@localhost:1521:xe";
String uid    = "scott";
String upw    = "tiger";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<table>
	<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "SELECT * FROM EMP";
		
	try{
	Class.forName(driver);
	conn = DriverManager.getConnection(url, uid, upw);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	
	if (rs.next()){
		out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번" +
				"</th><th colspan='3'>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
		do{
		
		int empno = rs.getInt("EMPNO");
		String ename = rs.getString("ENAME");
		String job = rs.getString("JOB");
		String mgr = rs.getString("MGR");
		Date hiredate1 = rs.getDate("HIREDATE");
		Timestamp hiredate2 = rs.getTimestamp("HIREDATE");
		
		int sal = rs.getInt("SAL");
		int comm = rs.getInt("COMM");
		int deptno = rs.getInt("DEPTNO");
		
		out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+(mgr==null? "없음":mgr)+"</td><td colspan='3'>"+hiredate1+"</td><td>"+
		sal+"</td><td>"+comm+"</td><td>"+deptno+"</td></tr>");
		} while (rs.next()); // 다음줄이 더 있으면, 다음줄을 계속해서 출력할 수 있도록 do while사용. 
		//while사용할 경우 첫번째 줄이 생략되니 주의하자
		
	} else {
		out.println("<tr><td>입력된 데이터가 없습니다</td></tr>");
	}	
		
	} catch (Exception e){
		System.out.println(e.getMessage());
	} finally {
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		if (conn!=null) conn.close();
	}
	%>
	</table>
</body>
</html>