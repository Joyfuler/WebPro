<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
%>
<%String search = request.getParameter("search");
if (search == null) {
	search = "";
}
String trimedSearch = search.trim().toUpperCase();
String dnameInput = request.getParameter("dname");
if (dnameInput ==null){
	dnameInput = "";
}
%>
<%!String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;%>
<% String sql = "SELECT DNAME FROM DEPT"; %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<script>
function clickReset(){
	var op = document.getElementsByTagName('option');
	op[0].selected = true;	
	var input = document.getElementsByName('search');
	input[0].value = '';
	document.getElementsByTagName('form')[0].submit();
}
</script>
<body>
	<form action="">
		<table>
			<tr>
				<td colspan="8">
				<select name = "dname">
				<option value = "">
				</option>				
				<%try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String dname = rs.getString("dname");
					if (dname.equals(dnameInput)){
						out.print("<option value ='"+dname+"' selected = 'selected'>"+dname+"</option>");	
					} else {
						out.print("<option value ='"+dname+"'>"+dname+"</option>");
					}
				}	
				} catch (Exception e) {
					out.print(e.getMessage());
				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} %>				
				</select>
				사원명 <input type="text" name="search"
					value='<%if (trimedSearch != null) {
							out.print(trimedSearch);
							}%>'>							
			<input type="submit" value="검색"> <input type = "button" value = "초기화" onclick="clickReset()"></tr>
			<tr><th>사번</th>
				<th>이름</th>
				<th>직책</th>
				<th>상사사번</th>
				<th>입사일</th>
				<th>급여</th>
				<th>부서번호</th>
				<th>부서명</th></tr>			
			<% 
			sql = "SELECT * FROM EMP,DEPT" + " WHERE EMP.DEPTNO = DEPT.DEPTNO AND ENAME LIKE '%'||?||'%' AND DNAME LIKE '%'||?||'%'";
						
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, trimedSearch);
				pstmt.setString(2, dnameInput);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					out.println("<tr><td>" + empno + "</td><td>" + ename + "</td><td>" + job + "</td><td>" + 
					(mgr == 0 ? "없음" : mgr) + "</td><td>" + hiredate + "</td><td>" + sal + "</td><td>" 
					+ deptno + "</td><td>" + dname + "</td></tr>");
				}
			} catch (Exception e) {
				out.print(e.getMessage());
			} finally {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} %>
		</table>
	</form>
</body>
</html>