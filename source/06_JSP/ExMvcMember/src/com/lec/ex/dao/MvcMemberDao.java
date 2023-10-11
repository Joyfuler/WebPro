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
import com.lec.ex.dto.MvcMemberDto;

public class MvcMemberDao {
	public final static int EXIST = 1;
	public final static int NONEXIST = 0;
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;	
	private DataSource ds;
	private static MvcMemberDao INSTANCE = new MvcMemberDao();

	public static MvcMemberDao getInstance() {
		return INSTANCE;
	}
	
	public MvcMemberDao() {		
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 1. mid 중복체크
	public int idConfirm(String mid) {
		int result = EXIST;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER2 WHERE MID = ?";		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				result = NONEXIST;
				System.out.println(mid + "는 회원가입 가능");
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(mid + "는 회원가입 불가");
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
	public int joinMember(MvcMemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;		
		String sql = "INSERT INTO MVC_MEMBER2 (MID, MPW, MNAME, MEMAIL, MBIRTH) "+ 
				"VALUES (?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMpw());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getMemail());			
			pstmt.setDate(5, dto.getMbirth());			
			result = pstmt.executeUpdate();
			System.out.println(dto.getMid() + "가입완료");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + dto);			
		} finally {
			try {			
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
	
	// 3.로긴첵
	public int loginCheck(String mid, String mpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER2 "
				+ "WHERE MID = ? AND MPW = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
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
	// 4. dto 가져오기
	public MvcMemberDto getMember(String mid) {
		MvcMemberDto member = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER2 WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);			
			rs = pstmt.executeQuery();
			if (rs.next()) {			
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");				
				Date mbirth = rs.getDate("mbirth");				
				Timestamp mrdate = rs.getTimestamp("mrdate");				
				member = new MvcMemberDto(mid, mpw, mname, memail, mbirth, mrdate);
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
		return member;
	}	
}
