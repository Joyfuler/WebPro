package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		// driver, url, sql 객체를 각각 생성하고 값을 넣어줌. 아래에서 사용
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM EMP"; // sql 쿼리문장을 던짐. 받는 방법은?
		Connection conn = null;
		Statement stmt = null; // 셋다 import해주고, 객체를 생성할 것. 변수초기화
		ResultSet rs = null;
		// 이후 드라이브 로드, 읽기, 닫기 절차를 거치자.
		try {
			Class.forName(driver); // 1. 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB를 연결
			stmt = conn.createStatement(); // 3. sql 전송객체.
			rs = stmt.executeQuery(sql); // 4. sql을 전송함. + 5. 전송 결과를 받음. (아마도 emp테이블 14줄)
			// 6. 전송 결과에 따른 원하는 로직.. (결과가 없으면? 등록된 데이터가 없습니다 등으로 출력)
			// 가져오는 방법은? while문을 수행해서 하나씩 값을 가져오게 만듬.
			if (rs.next()) { // rs.next() = true, 즉 다음 값이 있다는 의미.
			System.out.println("사번\t이름\t\t직책\t상사사번\t입사일\t\t급여\t상여\t부서번호"); // 타이틀을 우선 뿌림
				do {
					int empno = rs.getInt("EMPNO"); // empno라는 타이틀에 있는 값을 변수에 넣기. alias 사용가능.
					String ename = rs.getString("ENAME");
					String job = rs.getString("JOB");
					String mgr = rs.getString("MGR"); // mgr에 null값이 있는 경우, int는 0으로 받음.
					// Date hiredate = rs.getDate("HIREDATE"); // 날짜만. 시간은 0시 0분 0초로 받아짐.
					Timestamp hiredate = rs.getTimestamp("HIREDATE"); // 시간을 포함하여 받고 싶다면.
					int sal = rs.getInt("SAL");
					int comm = rs.getInt("COMM");
					int deptno = rs.getInt("DEPTNO"); // 각 변수에 타이틀에 해당하는 값을 모두 할당.
					if (job.length() >= 6) {
						System.out.printf("%d\t %s\t %s\t %s\t %TF\t %d\t %d\t %d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);					
					} else {
					System.out.printf("%d\t %s\t %s\t\t %s\t %TF\t %d\t %d\t %d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}
					// 그러나 예약시간 등은 시분초를 받아야 할 때는 Timestamp를 사용해야 함.
										
				} while (rs.next()); // 다음 값이 있는 동안 무한반복. (rs는 데이터의 한 줄. (empno,ename,job등등...))

			} else { // select문 결과가 한 행도 없는 경우
				System.out.println("등록된 사원이 없습니다.");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { 
				if (rs != null) rs.close(); //닫아야 하는 변수들은 연 순서와 반대로 닫을 것.
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
