<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
<style>
p {
	text-align: center;
}
</style>
</head>
<%!String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;%>

<body>
	<form action="">
		<p>
			부서번호 <select name="deptno">
				<option value="0">선택해주세요</option>
				<%
					String deptnoStr = request.getParameter("deptno");
				if (deptnoStr == null) {
					deptnoStr = "0";
				}
				int deptnoInput = Integer.parseInt(deptnoStr);
				String sql = "SELECT * FROM DEPT";

				try {

					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					// 바꾸어야할 변수 (?) 가 없다면 바로 executeQuery하면 됨.
					rs = pstmt.executeQuery();
					while (rs.next()) {
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						String loc = rs.getString("loc");

						if (deptnoInput == deptno) { // 전달받은 받은 값과 input에 보인 값이 같다면 selected를 넣도록 함.
					out.println("<option value = '" + deptno + "' selected='selected'>" + deptno + "-" + dname + "-" + loc
							+ "</option>");
						} else { // 전달받은 값과 input에 보였던 값이 다르므로 selected를 생략.
					out.println("<option value = '" + deptno + "'>" + deptno + "-" + dname + "-" + loc + "</option>");
						}
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());

				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				}
				%>
			</select> <input type="submit" value="검색">
	</form>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>입사일</th>
			<th>부서번호</th>
			<th>부서명</th>
		</tr>
		<%
			sql = "SELECT EMPNO, ENAME, HIREDATE, EMP.DEPTNO, DNAME" + " FROM EMP,DEPT"
				+ " WHERE EMP.DEPTNO = DEPT.DEPTNO AND EMP.DEPTNO LIKE '%'||?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptnoInput);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// sql에 만족하는 데이터가 있다면
				do {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			Date hiredate = rs.getDate("hiredate");
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			out.println("<tr><td>" + empno + "</td><td>" + ename + "</td><td>" + hiredate + "</td><td>" + deptno
					+ "</td><td>" + dname + "</td>");
				} while (rs.next());
			} else {
				out.println("<tr><td colspan='5'>해당하는 값이 없습니다 </td></tr>");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		%>

	</table>
</body>
</html>