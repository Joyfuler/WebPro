package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 수정할 부서번호를 받아 존재 여부를 확인하고, 부서명, 근무지를 입력받아 update
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.println("수정할 부서 번호는? : ");
			int deptno = scanner.nextInt();
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno; // 이 경우 결과가 안 나오기도 함. next로 판단해야
			rs = stmt.executeQuery(selectSQL);
			if (rs.next()) { // 존재하는 부서 번호이므로 수정 진행
				System.out.println("수정할 부서명은? : ");
				String dname = scanner.next();
				System.out.println("수정할 위치는? : ");
				String loc = scanner.next();
				String updateSQL = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO=%d", dname, loc,
						deptno);
				// 위에서 중복체크를 진행하였으므로, 아래에선 굳이 체크하지 않고 update하면 됨.
				int result = stmt.executeUpdate(updateSQL);
				if (result > 0) {
					System.out.println("수정성공!");
				}

			} else {
				System.out.println(deptno + "번 부서는 유효한 부서 번호가 아닙니다.");				

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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

	}
}
