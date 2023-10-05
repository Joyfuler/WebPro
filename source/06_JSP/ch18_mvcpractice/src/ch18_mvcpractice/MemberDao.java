package ch18_mvcpractice;

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
	private DataSource ds;	
	private static MemberDao INSTANCE = new MemberDao();
	public static MemberDao getInstance() {
		return INSTANCE;
	}
	private MemberDao() {		
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 1.회원리스트
	public ArrayList<MemberDto> listMember(){
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id      = rs.getString("id");
				String pw      = rs.getString("pw").replaceAll("[a-zA-Z0-9~`!@#$%^&*(]", "*");
				String name    = rs.getString("name");
				Date   birth   = rs.getDate("birth");
				Timestamp rdate= rs.getTimestamp("rdate");
				members.add(new MemberDto(id, pw, name, birth, rdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}  finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}		
			return members;
	}
	
	// 2. 회원가입
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, BIRTH) " + 
				"  VALUES (?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setDate(4, dto.getBirth());
			result = pstmt.executeUpdate();			
			System.out.println("가입성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("가입실패");
		} finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}			
		return result;
	}		
}

	