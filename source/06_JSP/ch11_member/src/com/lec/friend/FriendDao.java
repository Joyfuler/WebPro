package com.lec.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FriendDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	public static FriendDao INSTANCE = new FriendDao();
	// 싱글톤
	public static FriendDao getInstance() {
		return INSTANCE;
	}
	// getConnection
	private FriendDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection(url, uid, upw);
		return conn;
	}

	// 1. 친구추가 - public int insertfriend(String name, String tel){
	public int insertFriend(FriendDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO FRIEND (NO, NAME, TEL) " + "VALUES (FRIEND_NO_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("친구입력성공");
			} else {
				System.out.println("친구입력실패");
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
	// 2. 친구 리스트 출력 - public ArrayList<FriendDto> friendList(){}
	public ArrayList<FriendDto> friendList(String name, String tel){
		ArrayList<FriendDto> friendList = new ArrayList<FriendDto>();
		String sql = "";
		if(tel==null|| tel.equals("")) {
			sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND ? != 1";
		}else {
			sql = "SELECT * FROM FRIEND WHERE (NAME LIKE '%'||?||'%' AND TEL LIKE '%'||?||'%')";
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,tel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FriendDto dto = new FriendDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				friendList.add(dto);
			}	
			System.out.println("넘어온 파라미터 : " + name + " /" + tel) ;
			System.out.println("리스트 갯수 : " + friendList.size());
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
		return friendList;		
	}
	
	
	// 3.친구검색 (String id, String tel)
	public FriendDto friendSearch(String name, String tel) {
		FriendDto dto = new FriendDto();
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND TEL LIKE '%'||?||'%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;			
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setNString(2, tel);
			rs = pstmt.executeQuery();
			if (rs.next()) {
			dto.setName(rs.getString("name"));
			dto.setTel(rs.getNString("tel"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		return dto;
	}
}
