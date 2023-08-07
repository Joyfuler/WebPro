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
	public final static int SUCCESS = 1; // insert시 결과가 success인지 아닌지를 확인.
	public final static int FAIL = 0; // 실패시 0
	private static PersonDao INSTANCE = new PersonDao(); // persondao타입의 instance객체

	public static PersonDao getInstance() {
//		if (INSTANCE ==null) {
//			INSTANCE = new PersonDao();
//		}		
		return INSTANCE; // 만일 instance 만든적이 없다면 이 클래스에서 생성한 뒤 return.

	}

	// 무조건 persondao 객체를 넣는다면 일단 이것이 무조건실행됨
	public PersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	// 직업명을 ArrayList<String>으로 return하는 함수 직업명'들'이므로 arraylist.. 메인에서 쓸 수 있도록
	// public으로.
	public ArrayList<String> jnameList() { // 함수 - 타입 - 변수 - 리턴타입
		ArrayList<String> jnames = new ArrayList<String>();
		// 직업명들을 ArrayList에 add함. 완료되면 return
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB"; // 이 sql을 return하기 위한 함수. (배우,가수,개그맨)
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 쐈습니다. 이후 rs의 결과를 arraylist에 추가함.
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

		return jnames; // 배우, 가수, 개그맨을 return
	}

	// 1번 기능 dto (이름, 직업명, 국, 영, 수) 를 받아 DB에 insert하고 결과(1 또는 0을 return) --> 대신
	// success, fail을 리턴. (입력됐습니다 안됐습니다)

	public int insertPerson(PersonDto dto) { // 메인에서 사용자가 입력해야 하므로 매개변수에 dto 클래스 타입으로 변수를 넣어줌.
		int result = FAIL; // 안전하게 insert 안되는 상황으로 초기화
		Connection conn = null;
		PreparedStatement pstmt = null; // insert이므로 rs는 필요하지 않음.
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
			result = pstmt.executeUpdate(); // 0 아니면 1. 잘 update됐다면 success...
			System.out.println(result == SUCCESS ? "입력성공" : "입력실패");

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

	// 2번 기능 jname (String)을 받아 DB에 select한 결과를 ArrayList<PersonDto>로 return. 해당 결과가
	// 몇 줄일지 알 수 없으므로 ArrayList로 하고, 타입을 PersonDto로

	public ArrayList<PersonDto> selectJname(String jname) { // 사용자로부터 jname 매개변수를 받으므로 + 결과가 복수일 수 있으니 persondto타입의 배열로
															// 출력
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// DB 결과를 dtos에 add
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT ROWNUM RANK, A.*"
				+ " FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO AND"
				+ " JNAME= ? ORDER BY SUM DESC) A";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname); // 물음표는 1개. 매개변수로 들어오는 jname을 사용.
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("RANK");
				String pname = rs.getString("PNAME");
				// jname = rs.getString("JNAME"); 이미 매개변수로 들어왔으므로 생략됨.
				int kor = rs.getInt("KOR");
				int eng = rs.getInt("ENG");
				int mat = rs.getInt("MAT");
				int sum = rs.getInt("SUM");

				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
				// dtos 배열은 persondto타입이므로, new를 해 준 후 매개변수를 붙여준다.
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
		return dtos; // 배열로 나온 결과를 return
	}

	// 3번 기능 DB에 전체 select한 결과를 ArrayList<PersonDto>로 return.
	public ArrayList<PersonDto> selectAll() { // 매개변수가 없는 selectall문
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
