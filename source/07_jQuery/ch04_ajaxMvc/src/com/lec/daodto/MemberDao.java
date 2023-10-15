package com.lec.daodto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int EXIST = 1;
	public static final int NONEXIST = 0;
	DataSource ds = null;
	private static MemberDao INSTANCE = new MemberDao();

	public static MemberDao getInstance() {
		return INSTANCE;
	}

	public MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	public int midConfirm(String mid) {
		int result = EXIST;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = EXIST;
			} else {
				result = NONEXIST;
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

	// 2. ?öå?õêÍ∞??ûÖ
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_MEMBER " + "(mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMpw());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getMemail());
			pstmt.setString(5, dto.getMphoto());
			pstmt.setDate(6, dto.getMbirth());
			pstmt.setString(7, dto.getMaddress());
			result = pstmt.executeUpdate();
			System.out.println("?öå?õêÍ∞??ûÖ?Ñ±Í≥?");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "?öå?õêÍ∞??ûÖ?ã§?å® :" + dto);
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

	// 3. Î°úÍ∑∏?ù∏
	public int loginChk(String mid, String mpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE mID = ? and mPW = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = SUCCESS;
			}
		} catch (Exception e) {
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

	// 4. midÎ°? dtoÍ∞??†∏?ò§Í∏?
	public MemberDto getMemberInfo(String mid) {
		MemberDto memberInfo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE mId = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Timestamp mrdate = rs.getTimestamp("mrdate");
				memberInfo = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
			}
		} catch (Exception e) {
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
		return memberInfo;
	}

	// 5. ?öå?õê?†ïÎ≥¥Ïàò?†ï
	public int modifyMember(MemberDto member) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_MEMBER SET mPw = ?, mName = ?, "
				+"mEmail = ?, mPhoto = ?, "+
				"mBirth = ?, mAddress = ? WHERE mId = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMpw());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMphoto());
			pstmt.setDate(5, member.getMbirth());
			pstmt.setString(6, member.getMaddress());
			pstmt.setString(7, member.getMid());
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("º∫∞¯");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "ø°∑Ø : " + member);
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
	//6. ?öå?õê?†ïÎ≥? Î¶¨Ïä§?ä∏ (?éò?ù¥Ïß?)
	public ArrayList<MemberDto> getMemberList(int startRow, int endRow){
		ArrayList<MemberDto> lists = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * "
				+ "		FROM (SELECT ROWNUM RN, A.* "
				+ "				FROM (SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC) A) "
				+ "		WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();			
			while (rs.next()) {
				String mid       = rs.getString("mid");
				String mpw       = rs.getString("mpw");
				String mname     = rs.getString("mname");
				String memail    = rs.getString("memail");
				String mphoto    = rs.getString("mphoto");;
				Date   mbirth    = rs.getDate("mbirth");
				String maddress  = rs.getString("maddress");
				Timestamp mrdate = rs.getTimestamp("mrdate");
				lists.add(new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}		
		return lists;
	}
	// 7. Ï¥? ?öå?õê?àò (?éò?ù¥ÏßïÏö©)
	public int getMemberTotCnt() {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) CNT FROM MVC_MEMBER";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("CNT");			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}		
		return totCnt;
	}
	
	//8. ?öå?õê?Éà?á¥
	public int withdrawalMember(String mid) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql =  "DELETE FROM MVC_MEMBER WHERE MID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;		
	}
}
