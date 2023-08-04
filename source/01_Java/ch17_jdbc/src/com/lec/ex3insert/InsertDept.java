package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 부서번호, 부서명, 근무지를 입력받아 dept 테이블에 추가.
public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력할 부서번호는 (숫자 2자리 이내) ? : ");
		int deptno = scanner.nextInt();
		// 부서번호를 입력해서 우선 중복체크를 하도록 해야... 다음예제에서 ㄱㄱ
		
		System.out.println("입력할 부서명은 ? : ");
		String dname = scanner.next();
		System.out.println("입력할 부서위치는 ? : ");
		String loc = scanner.next();
		String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement(); // 여기까지는 select문과 동일함. 아래에서는 insert문을 쏠 때 사용하게 되는 구문.
			int result = stmt.executeUpdate(sql); // 결과는 1(줄 삽입됨), 0(줄 삽입됨) 이므로 int로 받아야함. insert, update, delete 문 전송시에
													// 사용함.
			// executequery() select문 전송. executeupdate() insert update delete 전송

			System.out.println(result > 0 ? "입력성공" : "입력실패");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("중복된 부서번호이거나 부서명, 위치를 너무 길게 입력한 경우 : " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close(); // db를 변경하는 insert등의 경우 반드시 close를 해야 함. 이후 다음에 해당 db를 사용하려 할 때 에러가 발생함.
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}
	}
}
