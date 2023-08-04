package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex2_selectWhereDeptno2 {
// 부서번호를 입력받고, 해당 부서번호가 존재하면 부서정보 + 사원정보(사번,이름,급여,상사이름)를 출력.
// 해당 부서번호가 없을 때 : "부서번호가 존재하지 않습니다."
// 부서번호는 있는데, 해당 부서에 사원이 없을 때 : 
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Scanner scanner = new Scanner(System.in);
		System.out.println("출력 원하는 부서번호는?");
		int deptno = scanner.nextInt();
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ') MANAGER" + " FROM EMP W, EMP M"
				+ " WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO =" + deptno;

		try {
			Class.forName(driver); // 드라이버불러오기. 1,2,3단계 꼭 준수!
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2단계. 객체 = drivermanager(url, 계정입력)
			stmt = conn.createStatement(); // 3단계> 객체 = 2단계객체.createStatement();
			rs = stmt.executeQuery(sql1); // dept테이블이므로 1줄바껭 없음
			if (rs.next()) {
				System.out.println("부서번호 : " + deptno);
				System.out.println("부서명 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc") + "\n");
				// 이제부터 sql2 출력.
				rs.close(); // 안전을 위해 일단 받고, 새롭게 sql문을 전송하자.
				rs = stmt.executeQuery(sql2);
				if (rs.next()) {
					System.out.println("사번\t이름\t급여\t상사\t");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);
					} while (rs.next());
				} else {
					System.out.println(deptno + "번의 사원이 없습니다.");
				}

			} else {
				System.out.println(deptno + "번 부서는 유효한 부서번호가 아닙니다.");
			}
		} catch (Exception e) {
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
