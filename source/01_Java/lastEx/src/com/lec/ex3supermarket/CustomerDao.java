package com.lec.ex3supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;

	// 싱글톤구현 = private 생성자에는 driver 로드 (1단계)
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	private static CustomerDao INSTANCE;

	public static CustomerDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDao();
		}
		return INSTANCE;
	}

	// 1. 회원가입메소드. 사용자에게 전화번호와 이름을 받아서 insert
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		// ctel과 cname으로 customer insert

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME)" + " VALUES (CUSTOMER_CID_SEQ.NEXTVAL, ?, ?)";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
			if (result == FAIL) {
				System.out.println("입력실패");
			} else {
				System.out.println("입력성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 2) 폰4자리검색 (SELECTTEL을 받아 CID,CNAME,CPOINT,CAMOUNT,LEVELNAME,FORLEVELUP)
	public ArrayList<CustomerDto> ctelGetCustomers(String searchTel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		// searchTel로 검색한 후, dtos에 add하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT,LEVELNAME,"
				+ " (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO !=5 AND CID=C.CID) FORLEVELUP FROM CUSTOMER C, CUS_LEVEL L"
				+ " WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||? ORDER BY CAMOUNT DESC, CID";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTel); // 매개변수로 들어온 searchTel을 ?에 넣어줌
			rs = pstmt.executeQuery(); // 결과는몇줄인지모르니배열로
			while (rs.next()) {
				int cid = rs.getInt("CID");
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				String levelName = rs.getString("LEVELNAME");
				int forLevelUp = rs.getInt("FORLEVELUP");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;

	}

	public int buy(int cid, int price) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE CUSTOMER "
				+ "SET CPOINT = CPOINT+(? * 0.05), CAMOUNT = CAMOUNT + ?, LEVELNO = (SELECT L.LEVELNO "
				+ "FROM CUSTOMER C, CUS_LEVEL L WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID=?) WHERE CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("구매성공");
			} else {
				System.out.println("구매실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public CustomerDto getCustomer(int cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT (HIGH+1)-CAMOUNT FROM CUSTOMER WHERE LEVELNO!= 5 AND CID = C.CID) FORLEVELUP"
				+ " FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO AND CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 결과값은 배열이 아니라 1개뿐이므로, while 대신 if를이용하여 출력한다.
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				String levelName = rs.getString("LEVELNAME");
				int forLevelUp = rs.getInt("FORLEVELUP");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp);
			} else { // rs.next()가 없을때 = 결과값이 없을때
				System.out.println("결과값이 없습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dto;

	}

	public ArrayList<String> getLevelNames() {
		ArrayList<String> levelNames = new ArrayList<String>(); // 기본적으로 아무것도 없는 것을 생성하고 최악의 경우 이를 그대로리턴함.
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				levelNames.add(rs.getString("LEVELNAME"));
				// arraylist라면 항상 while을 잊지 말것! 반복문으로 해야데이터를 모두 출력할수있음
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return levelNames;
	}

	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) { // 해당등급의고객출력
		ArrayList<CustomerDto> list = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT (HIGH+1)-CAMOUNT FROM CUSTOMER WHERE LEVELNO != 5 AND CID = C.CID) FORLEVELUP"
				+ " FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME=UPPER(?) ORDER BY CAMOUNT DESC, CID";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("CID");
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				int forLevelUp = rs.getInt("FORLEVELUP");
				list.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	public ArrayList<CustomerDto> Getcustomers() {
		ArrayList<CustomerDto> list = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT (HIGH+1)-CAMOUNT FROM CUSTOMER WHERE LEVELNO != 5 AND CID = C.CID) FORLEVELUP"
				+ " FROM CUSTOMER C, CUS_LEVEL L WHERE C.LEVELNO=L.LEVELNO ORDER BY CAMOUNT DESC, CID";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int cid = rs.getInt("CID");
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				String levelName = rs.getString("LEVELNAME");
				int forLevelUp = rs.getInt("FORLEVELUP");
				list.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public int deleteCustomer(String ctel) {
		int result = FAIL;
		// ctel과 cname으로 customer insert

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CTEL= ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}