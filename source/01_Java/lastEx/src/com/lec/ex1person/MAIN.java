package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MAIN {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select jno from job where jname = ?";
		String sql2 = "insert into person values (person_seq.nextval,?,?,?,?,?)";
		int jno = 0;

		Scanner scanner = new Scanner(System.in);
		System.out.println("1번을 누르면 데이터를 입력합니다. \n2번을 누르면 해당 직업의 학생들의 점수를 출력합니다. \n3번을 누르면 모든 학생들의 점수를 출력합니다.");
		int answer = scanner.nextInt();
		scanner.nextLine();
		if (answer == 1) {
			System.out.println("1. 이름을 입력해주세요 (3글자)");
			String pname = scanner.nextLine();
			System.out.println("2. 직업명을 입력해주세요. (2글자)");
			String jname = scanner.nextLine();
			System.out.println("3. 국어점수를 입력해주세요. (숫자3자리까지)");
			int kor = scanner.nextInt();
			scanner.nextLine();
			System.out.println("4. 영어점수를 입력해주세요. (숫자3자리까지)");
			int eng = scanner.nextInt();
			scanner.nextLine();
			System.out.println("5. 수학점수를 입력해주세요. (숫자3자리까지)");
			int mat = scanner.nextInt();

			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, jname);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					jno = rs.getInt("jno");

				} else {
					System.out.println("잘못된 직업을 입력하였습니다.");
					scanner.close();
				}
				pstmt.close();
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, pname);
				pstmt.setInt(2, kor);
				pstmt.setInt(3, eng);
				pstmt.setInt(4, mat);
				pstmt.setInt(5, jno);
				int result = pstmt.executeUpdate();
				if (result > 0) {
					System.out.println("입력 완료.");
				} else {
					System.out.println("데이터가 입력되지 않았습니다.");
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else if (answer == 2) {
			System.out.println("출력을 원하는 직업을 입력해주세요. (배우or가수)");
			String jname = scanner.nextLine();
			String sql4 = "select rownum, pname, pno, jname, kor, eng, mat, total from"
					+ " (select pname, pno, jname, kor, eng, mat, (kor+eng+mat) total from job, person"
					+ " where job.jno=person.jno order by total desc) where jname = ?";
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql4);
				pstmt.setString(1, jname);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println("등수\t이름(pNO)\t\t직업\t국어\t영어\t수학\t총점");
					System.out.println("----------------------------------------");
					do {
						int rownum = rs.getInt("ROWNUM");
						String pname = rs.getString("PNAME");
						int pno = rs.getInt("PNO");
						int kor = rs.getInt("KOR");
						int eng = rs.getInt("ENG");
						int mat = rs.getInt("MAT");
						int total = rs.getInt("TOTAL");
						System.out.println(rownum + "등\t" + pname + "(" + pno + ")번\t\t" + jname + "\t" + kor + "\t"
								+ eng + "\t" + mat + "\t" + total);

					} while (rs.next());
				} else {
					System.out.println("요청하신 목록이 존재하지 않습니다.");
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (answer == 3) {
			String sql4 = "select rownum, pname, pno, jname, kor, eng, mat, total from"
					+ " (select pname, pno, jname, kor, eng, mat, (kor+eng+mat) total from job, person"
					+ " where job.jno=person.jno order by total desc)";

			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql4);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println("등수\t이름(pNO)\t\t직업\t국어\t영어\t수학\t총점");
					System.out.println("----------------------------------------");
					do {
						int rownum = rs.getInt("ROWNUM");
						String pname = rs.getString("PNAME");
						int pno = rs.getInt("PNO");
						String jname = rs.getString("JNAME");
						int kor = rs.getInt("KOR");
						int eng = rs.getInt("ENG");
						int mat = rs.getInt("MAT");
						int total = rs.getInt("TOTAL");
						System.out.println(rownum + "등\t" + pname + "(" + pno + ")번\t\t" + jname + "\t" + kor + "\t"
								+ eng + "\t" + mat + "\t" + total);

					} while (rs.next());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("잘못된 입력입니다.");
			scanner.close();
		}
	}

}
