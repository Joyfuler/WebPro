package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 부서명을 입력받아 해당 부서 사원을 출력 (사번, 이름, 상사이름, 급여, 급여등급, 상사 없으면 상사명에 -CEO- 라고 출력.
// 급여순으로 정렬)
// 부서명이 없으면 --> 해당 정보가 없습니다.
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT A.EMPNO, A.ENAME, NVL(B.ENAME,'-CEO-') SANGSA, A.MGR, A.SAL, GRADE"
				+ " FROM EMP A, EMP B, DEPT D, SALGRADE" + " WHERE A.SAL BETWEEN LOSAL AND HISAL"
				+ " AND A.MGR=B.EMPNO(+)" + " AND A.DEPTNO = D.DEPTNO" + " AND DNAME = UPPER(?) ORDER BY SAL DESC";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			Class.forName(driver);
			pstmt = conn.prepareStatement(sql);
			System.out.println("찾으실 부서를 입력해주세요 : ");
			String dname = scanner.next();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 해당 부서 사원 있음. 리스트출력..
				System.out.println("사번\t이름\t상사\t급여\t급여등급");
				do {
					int empno = rs.getInt("EMPNO");
					String ename = rs.getString("ENAME");
					String sangsa = rs.getString("SANGSA");
					int sal = rs.getInt("SAL");
					int grade = rs.getInt("GRADE");
					System.out.printf("%d\t%s\t%s\t%d\t%d\n", empno, ename, sangsa, sal, grade);
				} while (rs.next()); //다음값이 없을 때까지 반복하여 데이터를 출력함.

			} else {
				System.out.println("해당하는 부서가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
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
	}
}