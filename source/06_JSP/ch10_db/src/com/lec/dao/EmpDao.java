package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.dto.EmpDto;

public class EmpDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	public static EmpDao INSTANCE = new EmpDao(); // 자기 클래스를 참조하는 static 변수
	public static EmpDao getInstance() {
		return INSTANCE; // 이후 다른 클래스에서 사용할 수 있게 됨.
	}
	
	private EmpDao() { // 기본 생성자 함수에서는 db driver에 접속하는 기능을 꼭 넣자		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	// ex1: 모든 empList를 출력
	public ArrayList<EmpDto> EmpList(){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>(); // 아무것도 없는 초기값을 보험으로 만들기.
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");			
				dtos.add(new EmpDto(empno,ename,job,mgr,hiredate,sal,comm,deptno,null));
				// 마지막 매개변수는 emp테이블에서는 가져올 수 없으니 null로 대체함. (매개변수 숫자맞추기)
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		}
		return dtos;
	}	
	// ex2: 해당 부서번호의 empList 반환 
	public ArrayList<EmpDto> deptnoEmpList(int deptno){ // 매개변수로 들어올 부서번호를 넣어줌.
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>(); // 아무것도 없는 초기값을 보험으로 만들기.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP WHERE DEPTNO LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				deptno = rs.getInt("deptno"); // 만일 0 (전체)로 받는 경우 해당 deptno를 다시 뿌려주기 위함.				
				dtos.add(new EmpDto(empno,ename,job,mgr,hiredate,sal,comm,deptno,null));				
				// 마지막 매개변수 dname은는 emp테이블에서는 가져올 수 없으니 null로 대체함. (매개변수 숫자맞추기)
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		}
		return dtos;
	}	
	// ex3: 해당 부서번호의 empList를 반환, dname 포함(emp+dept equi join)
	public ArrayList<EmpDto> dnameEmpList(int deptno){ // 매개변수로 들어올 부서번호를 넣어줌.
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>(); // 아무것도 없는 초기값을 보험으로 만들기.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT E.*, DNAME "+
				"FROM EMP E, DEPT D " +
				"WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				deptno = rs.getInt("deptno"); // 만일 0 (전체)로 받는 경우 해당 deptno를 다시 뿌려주기 위함.
				String dname = rs.getString("dname");
				dtos.add(new EmpDto(empno,ename,job,mgr,hiredate,sal,comm,deptno,dname));				
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		}
		return dtos;
	}	
	// example : 사원명에 해당 문자가 포함된 empList 반환
	public ArrayList<EmpDto> enameEmpList(String schName){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>(); // 아무것도 없는 배열 우선 생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT E.*, DNAME "+
				"FROM EMP E, DEPT D " +
				"WHERE D.DEPTNO = E.DEPTNO AND ENAME LIKE '%'||TRIM(UPPER(?))||'%'";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno"); // 만일 0 (전체)로 받는 경우 해당 deptno를 다시 뿌려주기 위함.
				String dname = rs.getString("dname");
				dtos.add(new EmpDto(empno,ename,job,mgr,hiredate,sal,comm,deptno,dname));				
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		}		
		return dtos;
	}
}

