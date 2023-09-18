package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.CustomerDto;

public class CustomerDao {
	public static final int CUSTOMER_EXISTENT = 1;
	public static final int CUSTOMER_NONEXISTENT = 0;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL_ID = 0;
	public static final int LOGIN_FAIL_CPW = -1;
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 1.회원가입확인
	public int confirmID(String id) {
		int result = CUSTOMER_NONEXISTENT;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT COUNT(*) COUNTS FROM CUSTOMER WHERE CID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.getInt("COUNTS") == 1) {
				result = CUSTOMER_EXISTENT;
			} else {
				result = CUSTOMER_NONEXISTENT;
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
		return result;
	}
	// 2.회원가입 
	public int joinCustomer (CustomerDto dto) {
		int result = FAIL;
		String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER) " + 
				"VALUES (?, ?, ?, ?, ? , ? , " +
				"TO_DATE(?,'YYYY-MM-DD'), ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCgender());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원가입성공" : "회원가입실패");					
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
		return result;
	}
}
