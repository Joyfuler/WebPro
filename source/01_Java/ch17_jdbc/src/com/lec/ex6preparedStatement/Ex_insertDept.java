package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex_insertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		// 완벽하게 일치하는 sql문이 아닌 차후 완성될 sql문을 미리 작성하는 것이 가능함.
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)"; // 작은따옴표 없어야함. ?,?
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert문이므로 resultset은 필요없음
		System.out.print("추가할 부서번호는 ? ");
		int deptno = scanner.nextInt();
		System.out.print("추가할 부서명은 ? ");
		String dname = scanner.next();
		System.out.print("추가할 위치는 ? ");
		String loc = scanner.next();

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // 아직 물음표가 3개 존재하는 sql문. 완성시켜야함...
			// 그래서 물음표 3개는 어떻게 채워요...
			pstmt.setInt(1, deptno); // 첫번째 물음표에 deptno를 넣어줌.
			pstmt.setString(2, dname); // 두 번째 물음표에는 dname을 넣어줌. 타입 주의!
			pstmt.setString(3, loc); // 그리고 pstmt를 쏘는 방법은?
			int result = pstmt.executeUpdate(); // 이미 pstmt에 sql이 set한 후 prepare가 되었으므로, 안에는 아무것도 넣지 말아야함.
			System.out.println(result > 0 ? "입력성공" : "입력실패");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				System.out.println(e.getMessage());
			}

		}
	}
}
