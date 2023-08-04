package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 수정할 부서번호와 부서명, 근무지를 입력받아 update 전송
public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 우선 scanner를 통해 update할 값을 유저에게 받아둔다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("수정할 부서번호는 ? (숫자두자리) : ");
		int deptno = scanner.nextInt();
		// 부서번호의 유무 확인
		System.out.println("수정할 부서명은 ? (4글자이내) : ");
		String dname = scanner.next();
		System.out.println("수정할 부서의 위치는 ? : ");
		String loc = scanner.next();
		String sql = String.format("UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO=?");

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, deptno);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			int result = pstmt.executeUpdate(); // 1행 업데이트? 0행 업데이트?
			System.out.println(result > 0 ? deptno + "번 부서 수정됨" : deptno + "번 부서가 없어 수정 불가");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("너무 길거나 잘못입력해서 에러" + e.getMessage());
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

	}
}
