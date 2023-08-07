package prac.prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDaoprac {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	private static PersonDaoprac INSTANCE = new PersonDaoprac(); // 나중에 어디선가 이걸 소환하고 싶다면..

	public static PersonDaoprac getInstance() {
		return INSTANCE; // 다가져가라는 의미.
	}

	public PersonDaoprac() {
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String> jnamelist() {
		ArrayList<String> jnames = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				jnames.add(rs.getString("JNAME")); // string이므로 new 할 필요가 없음.
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
		return jnames;
	}

	public int insertPerson(PersonDtoprac dto) {
		int result = FAIL; // 결과값이 없을때는 fail로 반환. 있으면 result에 sql조건에 맞는 값이 배열로 출력되고 반환
		Connection conn = null;
		PreparedStatement pstmt = null;
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
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("입력 완료");

			} else {
				System.out.println("입력 실패.");
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

	public ArrayList<PersonDtoprac> selectJname(String jname) {
		ArrayList<PersonDtoprac> dtos = new ArrayList<PersonDtoprac>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*"
				+ " FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO AND"
				+ " JNAME=? ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("RANK");
				String pname = rs.getString("PNAME");
				int kor = rs.getInt("KOR");
				int eng = rs.getInt("ENG");
				int mat = rs.getInt("MAT");
				int sum = rs.getInt("SUM");
				dtos.add(new PersonDtoprac(rank, pname, jname, kor, eng, mat, sum));
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
		return dtos;

	}
	
	public ArrayList <PersonDtoprac> selectAll(){
	ArrayList<PersonDtoprac> dtos = new ArrayList<PersonDtoprac>();	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "SELECT ROWNUM RANK, A.* " 
			+ "FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM "
			+ "FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO ORDER BY SUM DESC) A";
	
	try {
		conn = DriverManager.getConnection(url, "scott", "tiger");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			int rank = rs.getInt("RANK");
			String pname = rs.getString("PNAME");
			String jname = rs.getString("JNAME");
			int kor = rs.getInt ("KOR");
			int eng = rs.getInt("ENG");
			int mat = rs.getInt("MAT");
			int sum = rs.getInt("SUM");
			dtos.add (new PersonDtoprac (rank,pname,jname,kor,eng,mat,sum));
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
			System.out.println(e.getMessage());
		}
	}	
	return dtos;
	}
}
