package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/jangdb?serverTimezone=UTC";
		String sql = "SELECT * FROM PERSONAL"; // 모두 출력하려면 필요한 것

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver); // 1단계.. 드라이버 로드
			System.out.println("드라이버로드성공");
			conn = DriverManager.getConnection(url, "root", "mysql");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
				while (rs.next()) {
					int pno = rs.getInt("pno"); // 괄호 안은 타이틀이며, alias를 만든 경우는 alias를 적을 것. (필드이름적는것아님!)
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					String manager = rs.getString("manager"); // null인 경우 0.
					Date startdate = rs.getDate("startdate"); // String으로 해도 되나 sdf를 사용할 수가 없으므로 date가 적합
					Timestamp startdate1 = rs.getTimestamp("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					if (job.length() >= 8) {
						System.out.printf("%d\t%s\t%s\t%s\t%TF\t%d\t%d\t%d\n",
								pno, pname, job, manager, startdate1, pay, bonus, dno); // 값 다 가져왔어? 그럼 close해!

					} else {
						System.out.printf("%d\t%s\t%s\t\t%s\t%TF\t%d\t%d\t%d\n",
								pno, pname, job, manager, startdate1, pay, bonus, dno);
					}
				}

			} else {
				System.out.println("값이 없습니다.");
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (rs != null) // db연결해제. 객체 생성했을 때와 반대 순서로 닫을 것.
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
