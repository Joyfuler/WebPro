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
		System.out.println("1���� ������ �����͸� �Է��մϴ�. \n2���� ������ �ش� ������ �л����� ������ ����մϴ�. \n3���� ������ ��� �л����� ������ ����մϴ�.");
		int answer = scanner.nextInt();
		scanner.nextLine();
		if (answer == 1) {
			System.out.println("1. �̸��� �Է����ּ��� (3����)");
			String pname = scanner.nextLine();
			System.out.println("2. �������� �Է����ּ���. (2����)");
			String jname = scanner.nextLine();
			System.out.println("3. ���������� �Է����ּ���. (����3�ڸ�����)");
			int kor = scanner.nextInt();
			scanner.nextLine();
			System.out.println("4. ���������� �Է����ּ���. (����3�ڸ�����)");
			int eng = scanner.nextInt();
			scanner.nextLine();
			System.out.println("5. ���������� �Է����ּ���. (����3�ڸ�����)");
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
					System.out.println("�߸��� ������ �Է��Ͽ����ϴ�.");
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
					System.out.println("�Է� �Ϸ�.");
				} else {
					System.out.println("�����Ͱ� �Էµ��� �ʾҽ��ϴ�.");
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
			System.out.println("����� ���ϴ� ������ �Է����ּ���. (���or����)");
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
					System.out.println("���\t�̸�(pNO)\t\t����\t����\t����\t����\t����");
					System.out.println("----------------------------------------");
					do {
						int rownum = rs.getInt("ROWNUM");
						String pname = rs.getString("PNAME");
						int pno = rs.getInt("PNO");
						int kor = rs.getInt("KOR");
						int eng = rs.getInt("ENG");
						int mat = rs.getInt("MAT");
						int total = rs.getInt("TOTAL");
						System.out.println(rownum + "��\t" + pname + "(" + pno + ")��\t\t" + jname + "\t" + kor + "\t"
								+ eng + "\t" + mat + "\t" + total);

					} while (rs.next());
				} else {
					System.out.println("��û�Ͻ� ����� �������� �ʽ��ϴ�.");
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
					System.out.println("���\t�̸�(pNO)\t\t����\t����\t����\t����\t����");
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
						System.out.println(rownum + "��\t" + pname + "(" + pno + ")��\t\t" + jname + "\t" + kor + "\t"
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
			System.out.println("�߸��� �Է��Դϴ�.");
			scanner.close();
		}
	}

}
