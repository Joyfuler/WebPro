<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
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
	String deptnoStr = request.getParameter("deptno");
	if (deptnoStr == null){
		deptnoStr = "0"; // 만일 받은 패러미터가 없다면, 0으로 초기화해줌 (모두출력이 됨)
	}
	int deptno = Integer.parseInt(deptnoStr);
	String sql = "SELECT * FROM EMP WHERE DEPTNO LIKE '%'||?";
	try{
		Class.forName(driver); //1단계
		conn = DriverManager.getConnection(url, "scott", "tiger");
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptno);
		rs = pstmt.executeQuery();
		out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>부서번호</th></tr>");		
		System.out.println(1);
		if (rs.next()){
			do {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			int deptno2 = rs.getInt("deptno");
			out.print("<tr><td>" + empno + "</td><td>" + ename + "</td><td>" + job + "</td><td>" + deptno2 + "</td></tr>");
			} while (rs.next());
			
		} else {
			out.print("<tr><td colspan='4'>해당 부서번호의 사원이 없습니다</td></tr>");
		}
		
	} catch (Exception e){
		System.out.println(e.getMessage());
	} finally {
		if (rs!=null) rs.close();
		if (pstmt!=null) pstmt.close();
		if (conn!=null) conn.close();
	}
		
	
	%>
	</table>
</body>
</html>