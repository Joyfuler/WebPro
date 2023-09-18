package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MemberDaoCP {
	public static final int MEMBER_EXISTENT = 0; // 회원가입시 아이디 중복 체크. 리턴되는 값이 없으면
	public static final int MEMBER_NONEXISTENT = 1; // 사용 가능한 ID일 경우 return값.
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공시. id/pw 모두 맞는 값이 존재.
	public static final int LOGIN_FAIL_PW = 0; // 로그인시 비밀번호를 잘못 친 경우
	public static final int LOGIN_FAIL_ID = -1; // 로그인시 아이디를 잘못 친 경우
	public static int SUCCESS = 1; // 회원정보 수정 성공했을 때. update나 insert는 수행성공시 1을 반환함
	public static int FAIL = 0; // 회원정보 수정 실패시.
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
//
//	public static MemberDao INSTANCE = new MemberDao(); // 타입은 내 클래스를 참조하도록.
//	
//
//	public static MemberDao getInstance() {
//		return INSTANCE;
//	}
//
//	private MemberDao() { 
//		try {
//			Class.forName(driver); 
//		} catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//	}

	// connection pool을 이용한 db연결. (반응속도 향상을 위한)
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	
	public int confirmID(String id) {
		int result = MEMBER_EXISTENT;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
		
			if (rs.next()) {
				result = MEMBER_EXISTENT;
			} else {
				result = MEMBER_NONEXISTENT;
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

	
	public int joinMember(MemberDto dto) { 
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID,PW, NAME, PHONE1, PHONE2, PHONE3, "
				+ "GENDER, EMAIL, BIRTH, ADDRESS, RDATE) " + "VALUES (?, ?, ?, ?, ?, ?, " + "?, ?, ?, ?, SYSDATE)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setDate(9, dto.getBirth());
			pstmt.setString(10, dto.getAddress());		
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원가입성공" : "회원가입실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패: " + dto);		
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

	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 조건에 부합하는 데이터 O , 즉 제대로 입력하였음.
				String dbPw = rs.getString("pw"); // db에 있는 pw 데이터를 가져옴.
				if (dbPw.equals(pw)) {
					result = LOGIN_SUCCESS;
				} else {
					result = LOGIN_FAIL_PW;
				}
			} else { // 조건에 부합하는 데이터 x, 즉 맞는 데이터 없음.
				result = LOGIN_FAIL_ID;
			}			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	
	// 4. 로그인 성공시 SESSION에 setAttribute할 회원 정보 (id로 dto 가져오기)
	// public MemberDto getMember (String id)
	// 만일 정보가 일치하면 세션을 객체화하여 넘김
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?"; //sql문 자체는 동일함. 해당 계정의 데이터 전체를 가져올 예정
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 조건에 부합하는 데이터는 0줄이거나, 1줄.
				// String id; 매개변수로 이미 들어와 있으므로 굳이 찾아올 필요가 업승ㅁ.
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
				String address = rs.getString("address");
				Timestamp rdate = rs.getTimestamp("rdate");
				dto = new MemberDto(id, pw, name, phone1, phone2, phone3, gender, email, birth, address, rdate);
				// 결과가 1줄이므로 dto에 객체 1개만 추가하면 됨. arraylist x
			} else { // 조건에 부합하는 데이터 x, 즉 맞는 데이터 없음.
				dto = null;
			}				
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		return dto;
	}
	
	// 5. 회원정보 수정 (아이디는 수정불가, 나머지는 수정가능)
	// public int modifyMember (MemberDto dto) --> 수정해야 할 매개변수를 가져와 객체로
	// 최악의 case인 fail을 기본으로 하고 return
	public int modifyMember (MemberDto dto) { // 변수량이 많으므로 객체로 가져와 return함.
		int result = FAIL; // 실패를 기본으로 설정
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PW = ?, "+ 
				"NAME = ?, " +
				"PHONE1=?, " +
				"PHONE2=?, " +
				"PHONE3=?, " +
				"GENDER=?, " +
				"EMAIL=?, " +
				"BIRTH=?, " +
				"ADDRESS=? WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setDate(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원정보수정완료" : "회원정보수정안됨:" + dto);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원수정 실패: " + dto);
			// dto를 받아서 받은 값들을 확인함. (입력할 때 빈 것이 있는지, 어떤 것이 오류인지를 확인)
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
}