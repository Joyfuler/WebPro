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

	// �̱��汸�� = private �����ڿ��� driver �ε� (1�ܰ�)
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

	// 1. ȸ�����Ը޼ҵ�. ����ڿ��� ��ȭ��ȣ�� �̸��� �޾Ƽ� insert
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		// ctel�� cname���� customer insert

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
				System.out.println("�Է½���");
			} else {
				System.out.println("�Է¼���");
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

	// 2) ��4�ڸ��˻� (SELECTTEL�� �޾� CID,CNAME,CPOINT,CAMOUNT,LEVELNAME,FORLEVELUP)
	public ArrayList<CustomerDto> ctelGetCustomers(String searchTel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		// searchTel�� �˻��� ��, dtos�� add�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT,LEVELNAME,"
				+ " (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO !=5 AND CID=C.CID) FORLEVELUP FROM CUSTOMER C, CUS_LEVEL L"
				+ " WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||? ORDER BY CAMOUNT DESC, CID";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTel); // �Ű������� ���� searchTel�� ?�� �־���
			rs = pstmt.executeQuery(); // ����¸��������𸣴Ϲ迭��
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
				System.out.println("���ż���");
			} else {
				System.out.println("���Ž���");
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
			if (rs.next()) { // ������� �迭�� �ƴ϶� 1�����̹Ƿ�, while ��� if���̿��Ͽ� ����Ѵ�.
				String ctel = rs.getString("CTEL");
				String cname = rs.getString("CNAME");
				int cpoint = rs.getInt("CPOINT");
				int camount = rs.getInt("CAMOUNT");
				String levelName = rs.getString("LEVELNAME");
				int forLevelUp = rs.getInt("FORLEVELUP");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp);
			} else { // rs.next()�� ������ = ������� ������
				System.out.println("������� �����ϴ�.");
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
		ArrayList<String> levelNames = new ArrayList<String>(); // �⺻������ �ƹ��͵� ���� ���� �����ϰ� �־��� ��� �̸� �״�θ�����.
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
				// arraylist��� �׻� while�� ���� ����! �ݺ������� �ؾߵ����͸� ��� ����Ҽ�����
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

	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) { // �ش����ǰ����
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
		// ctel�� cname���� customer insert

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