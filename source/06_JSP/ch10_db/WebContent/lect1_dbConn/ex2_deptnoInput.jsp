<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
<style>
p{
text-align: center;}
</style>
</head>
<body>
<form action = "ex2_empOutput.jsp" method = "get">
<p>
부서번호 <select name = "deptno">
<option value = "0">선택해주세요</option>
<%
	String sql = "SELECT * FROM DEPT ORDER BY DEPTNO";
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,"scott","tiger");
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();		
		while (rs.next()){
			// out.println("<option value = '10'>10-ACCOUNTING-NEW YORK </option>"); 식으로 출력
			int deptno = rs.getInt("DEPTNO");
			String dname = rs.getString("DNAME");
			String loc = rs.getString("LOC");
			out.println("<option value = '"+deptno+"'>"+deptno+"-"+dname+"-"+loc+"</option>"); 
		}
		
		
	} catch (Exception e){
		System.out.println(e.getMessage());
	} finally {
		if (rs!=null) rs.close();
		if (pstmt!=null) pstmt.close();
		if (conn!=null) conn.close();
	}

%>
</select><input type = "submit" value = "검색">
</p>
</form>
</body>
</html>