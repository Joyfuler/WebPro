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
		ArrayList<String> jobs = new ArrayList<String>(); // DB�� �ִ� ��������� add..
		try {
			sql = "SELECT JNAME FROM JOB";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jobs.add(rs.getString("JNAME")); // job�� �ִ� ��� jname�� jobs �迭�� �߰���.
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
			// System.out.println("db�� �ִ� ������� : " + jobs);
		}
		do {
			System.out.println("1. �Է� || 2: ��������ȸ || 3:: ��ü��ȸ || �׿�: ����");
			fn = scanner.next();
			switch (fn) {
			case "1": // �̸�, ������, ��, ��, �� �Է¹޾� insert
				System.out.println("1�� ��� ����");
				sql = "INSERT INTO PERSON VALUES"
						+ " (PERSON_PNO_SEQ.NEXTVAL, (SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("�Է��� �̸���? ");
					pstmt.setString(2, scanner.next());
					System.out.println("�Է��� ���� (" + jobs + ")��?");
					pstmt.setString(1, scanner.next());
					System.out.println("����������?");
					pstmt.setInt(3, scanner.nextInt());
					System.out.println("����������?");
					pstmt.setInt(4, scanner.nextInt());
					System.out.println("����������?");
					pstmt.setInt(5, scanner.nextInt());
					int result = pstmt.executeUpdate(); // 0 Ȥ�� 1
					System.out.println(result > 0 ? "�Է� ����" : "�Է� ����");
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
			case "2": // �������� �Է¹޾� ���
				System.out.println("2�� ��� ����");
				sql = "SELECT ROWNUM RANK, A.* "
						+ "FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO AND"
						+ " JNAME= ? ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("����ϰ��� �ϴ� ������(" + jobs + ")��?");
					pstmt.setString(1, scanner.next());
					rs = pstmt.executeQuery();
					if (rs.next()) { // ������ ��·���
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("RANK");
							String pname = rs.getString("PNAME");
							String jname = rs.getString("JNAME");
							int kor = rs.getInt("KOR");
							int eng = rs.getInt("ENG");
							int mat = rs.getInt("MAT");
							int sum = rs.getInt("SUM");
							System.out.println(rank + "��\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t"
									+ mat + "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("ǥ���� �����Ͱ� �����ϴ�.");
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
			case "3": // ��ü���
				System.out.println("3�� ��� ����");
				sql = "SELECT ROWNUM RANK, A.* "
						+ "FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON, JOB WHERE PERSON.JNO=JOB.JNO"
						+ " ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);				
					rs = pstmt.executeQuery();
					if (rs.next()) { // ������ ��·���
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("RANK");
							String pname = rs.getString("PNAME");
							String jname = rs.getString("JNAME");
							int kor = rs.getInt("KOR");
							int eng = rs.getInt("ENG");
							int mat = rs.getInt("MAT");
							int sum = rs.getInt("SUM");
							System.out.println(rank + "��\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t"
									+ mat + "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("ǥ���� �����Ͱ� �����ϴ�.");
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
