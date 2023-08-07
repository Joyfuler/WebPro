package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>(); // DB에 있는 직업명들을 add..
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jobs.add(rs.getString("JNAME")); // job에 있는 모든 jname이 jobs 배열에 추가됨.
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
			// System.out.println("db에 있는 직업명들 : " + jobs);
		}
		do {
			System.out.println("1. 입력 || 2: 직업별조회 || 3:: 전체조회 || 그외: 종료");
			fn = scanner.next();
			switch (fn) {
			case "1": // 이름, 직업명, 국, 영, 수 입력받아 insert
				System.out.println("1번 기능 실행");
				sql = "INSERT INTO PERSON VALUES"
						+ " (PERSON_PNO_SEQ.NEXTVAL, (SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("입력할 이름은? ");
					pstmt.setString(2, scanner.next());
					System.out.println("입력할 직업 (" + jobs + ")은?");
					pstmt.setString(1, scanner.next());
					System.out.println("국어점수는?");
					pstmt.setInt(3, scanner.nextInt());
					System.out.println("영어점수는?");
					pstmt.setInt(4, scanner.nextInt());
					System.out.println("수학점수는?");
					pstmt.setInt(5, scanner.nextInt());
					int result = pstmt.executeUpdate(); // 0 혹은 1
					System.out.println(result > 0 ? "입력 성공" : "입력 실패");
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
						System.out.println(e.getMessage());
					}
				}
				break;
			case "2": // 직업명을 입력받아 출력
				System.out.println("2번 기능 실행");
				sql = "SELECT ROWNUM RANK, A.* "
						+ "FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO AND"
						+ " JNAME= ? ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("출력하고자 하는 직업명(" + jobs + ")은?");
					pstmt.setString(1, scanner.next());
					rs = pstmt.executeQuery();
					if (rs.next()) { // 직업별 출력로직
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("RANK");
							String pname = rs.getString("PNAME");
							String jname = rs.getString("JNAME");
							int kor = rs.getInt("KOR");
							int eng = rs.getInt("ENG");
							int mat = rs.getInt("MAT");
							int sum = rs.getInt("SUM");
							System.out.println(rank + "등\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t"
									+ mat + "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("표시할 데이터가 없습니다.");
					}
				} catch (SQLException e) {
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
						System.out.println(e.getMessage());
					}
				}
				break;
			case "3": // 전체출력
				System.out.println("3번 기능 실행");
				sql = "SELECT ROWNUM RANK, A.* "
						+ "FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO"
						+ " ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);				
					rs = pstmt.executeQuery();
					if (rs.next()) { // 직업별 출력로직
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("RANK");
							String pname = rs.getString("PNAME");
							String jname = rs.getString("JNAME");
							int kor = rs.getInt("KOR");
							int eng = rs.getInt("ENG");
							int mat = rs.getInt("MAT");
							int sum = rs.getInt("SUM");
							System.out.println(rank + "등\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t"
									+ mat + "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("표시할 데이터가 없습니다.");
					}
				} catch (SQLException e) {
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
						System.out.println(e.getMessage());
					}
				}
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
