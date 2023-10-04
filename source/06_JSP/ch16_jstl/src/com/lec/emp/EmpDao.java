package com.lec.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDao {
	
	
	private EmpDao() {}
	private static EmpDao INSTANCE = new EmpDao();
	public static EmpDao getInstance() {
		return INSTANCE;
	}
	// Connection 리턴함수
	private Connection getConnection() throws SQLException {
		Connection conn = null;		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); // 10개 커넥션풀 쌓아놓음
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}		
		return conn;
	}
	public ArrayList<EmpDto> getListEmp(){
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr"); //mgr이 null이면 0을 가져옴.
				Timestamp hiredate  = rs.getTimestamp("hiredate");
				Date hireDate = rs.getDate("hireDate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				list.add(new EmpDto(empno, ename, job, mgr, hiredate, 
						hireDate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null) stmt.close();
				if (conn!=null) conn.close();				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}		
		return list;
	}
	
	public ArrayList<EmpDto> getListEmp(String schName, String schJob){
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER(TRIM(?))||'%' "
				+ "AND JOB LIKE '%'||TRIM(UPPER(?))||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName);
			pstmt.setNString(2, schJob);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr"); //mgr이 null이면 0을 가져옴.
				Timestamp hiredate  = rs.getTimestamp("hiredate");
				Date hireDate = rs.getDate("hireDate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				list.add(new EmpDto(empno, ename, job, mgr, hiredate, 
						hireDate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}				
		return list;
	}
}
