	package com.lec.ex2person_DtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static int SUCCESS = 1; // insert�� ����� success���� �ƴ����� Ȯ��.
	public final static int FAIL = 0; // ���н� 0
	private static PersonDao INSTANCE = new PersonDao(); // persondaoŸ���� instance��ü

	public static PersonDao getInstance() {
//		if (INSTANCE ==null) {
//			INSTANCE = new PersonDao();
//		}		
		return INSTANCE; // ���� instance �������� ���ٸ� �� Ŭ�������� ������ �� return.

	}

	// ������ persondao ��ü�� �ִ´ٸ� �ϴ� �̰��� �����ǽ����
	public PersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	// �������� ArrayList<String>���� return�ϴ� �Լ� ������'��'�̹Ƿ� arraylist.. ���ο��� �� �� �ֵ���
	// public����.
	public ArrayList<String> jnameList() { // �Լ� - Ÿ�� - ���� - ����Ÿ��
		ArrayList<String> jnames = new ArrayList<String>();
		// ��������� ArrayList�� add��. �Ϸ�Ǹ� return
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB"; // �� sql�� return�ϱ� ���� �Լ�. (���,����,���׸�)
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // �����ϴ�. ���� rs�� ����� arraylist�� �߰���.
			while (rs.next()) {
				jnames.add(rs.getString("JNAME"));
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
				System.out.println(e.getMessage());
			}

		}

		return jnames; // ���, ����, ���׸��� return
	}

	// 1�� ��� dto (�̸�, ������, ��, ��, ��) �� �޾� DB�� insert�ϰ� ���(1 �Ǵ� 0�� return) --> ���
	// success, fail�� ����. (�Էµƽ��ϴ� �ȵƽ��ϴ�)

	public int insertPerson(PersonDto dto) { // ���ο��� ����ڰ� �Է��ؾ� �ϹǷ� �Ű������� dto Ŭ���� Ÿ������ ������ �־���.
		int result = FAIL; // �����ϰ� insert �ȵǴ� ��Ȳ���� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null; // insert�̹Ƿ� rs�� �ʿ����� ����.
		String sql = "INSERT INTO PERSON VALUES "
				+ "(PERSON_PNO_SEQ.NEXTVAL, (SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getJname());
			pstmt.setString(2, dto.getPname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate(); // 0 �ƴϸ� 1. �� update�ƴٸ� success...
			System.out.println(result == SUCCESS ? "�Է¼���" : "�Է½���");

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
				e.printStackTrace();
			}
		}
		return result;
	}

	// 2�� ��� jname (String)�� �޾� DB�� select�� ����� ArrayList<PersonDto>�� return. �ش� �����
	// �� ������ �� �� �����Ƿ� ArrayList�� �ϰ�, Ÿ���� PersonDto��

	public ArrayList<PersonDto> selectJname(String jname) { // ����ڷκ��� jname �Ű������� �����Ƿ� + ����� ������ �� ������ persondtoŸ���� �迭��
															// ���
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// DB ����� dtos�� add
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT ROWNUM RANK, A.*"
				+ " FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO AND"
				+ " JNAME= ? ORDER BY SUM DESC) A";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname); // ����ǥ�� 1��. �Ű������� ������ jname�� ���.
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("RANK");
				String pname = rs.getString("PNAME");
				// jname = rs.getString("JNAME"); �̹� �Ű������� �������Ƿ� ������.
				int kor = rs.getInt("KOR");
				int eng = rs.getInt("ENG");
				int mat = rs.getInt("MAT");
				int sum = rs.getInt("SUM");

				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
				// dtos �迭�� persondtoŸ���̹Ƿ�, new�� �� �� �� �Ű������� �ٿ��ش�.
			}

		} catch (Exception e) {
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
		return dtos; // �迭�� ���� ����� return
	}

	// 3�� ��� DB�� ��ü select�� ����� ArrayList<PersonDto>�� return.
	public ArrayList<PersonDto> selectAll() { // �Ű������� ���� selectall��
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT ROWNUM RANK, A.*"
				+ " FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO"
				+ " ORDER BY SUM DESC) A";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			
			while (rs.next()) {
				int rank = rs.getInt("RANK");
				String pname = rs.getString("PNAME");
				String jname = rs.getString("JNAME");
				int kor = rs.getInt("KOR");
				int eng = rs.getInt("ENG");
				int mat = rs.getInt("MAT");
				int sum = rs.getInt("SUM");
				dtos.add(new PersonDto(rank,pname,jname,kor,eng,mat,sum));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
}
