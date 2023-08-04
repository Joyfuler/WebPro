package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 입력받은 부서번호를 중복 체크한 후 부서명, 위치를 입력받아 insert함
public class Ex2_InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from dept where deptno = ?";
		String sql2 = "insert into dept values (?, ?, ?)";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			System.out.println("추가하고 싶은 부서번호를 입력하세용");
			int deptno = scanner.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next(); // 1줄 출력.
			int cnt = rs.getInt("cnt");
			if (cnt != 0) {
				System.out.println("이미 있는 부서번호라 생성할 수 없음");
			} else { // 중복체크 완료했으니, 다음은 입력할 값 필요.
				rs.close();
				pstmt.close(); // 먼저 닫기 조심!! 다시 쓸때 다시 열것
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, deptno);
				System.out.println("추가하고 싶은 부서명을 입력하세용");
				pstmt.setString(2, scanner.next());
				System.out.println("추가하고 싶은 장소를 입력하세용");
				pstmt.setString(3, scanner.next());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					System.out.println("부서 생성 완료");
				} else {
					System.out.println("부서 생성 실패");
				}
			}

//			System.out.println("추가하고 싶은 부서명을 입력하세용");
//			pstmt.setString(2,scanner.next());
//			System.out.println("추가하고 싶은 위치를 입력하세용");
//			pstmt.setString(3,scanner.next());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	}
}
