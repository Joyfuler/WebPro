package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.AdminDto;
import com.lec.ex.dto.MemberDto;

public class AdminDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public DataSource ds;
	private static AdminDao INSTANCE = new AdminDao();
	
	public static AdminDao getInstance() {		
		return INSTANCE;
	}
	public AdminDao() {		
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// (1) admin 로그인
	public int adminLoginChk(String aid, String apw) {
		int result = FAIL;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ADMIN WHERE AID = ? AND APW = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);	
			pstmt.setString(2, apw);
			rs = pstmt.executeQuery();
			if (rs.next()) {			
				result = SUCCESS;
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
	
	// 로그인 후 세션넣기 (dto 가져오기)
	
	public AdminDto getAdmindto (String aid) {
		AdminDto admin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ADMIN WHERE AID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String apw = rs.getString("apw");
				String aname = rs.getString("aname");
				admin = new AdminDto(aid, apw, aname);
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
		return admin;
	}
}
