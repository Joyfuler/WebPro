package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex_insertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		// �Ϻ��ϰ� ��ġ�ϴ� sql���� �ƴ� ���� �ϼ��� sql���� �̸� �ۼ��ϴ� ���� ������.
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)"; // ��������ǥ �������. ?,?
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert���̹Ƿ� resultset�� �ʿ����
		System.out.print("�߰��� �μ���ȣ�� ? ");
		int deptno = scanner.nextInt();
		System.out.print("�߰��� �μ����� ? ");
		String dname = scanner.next();
		System.out.print("�߰��� ��ġ�� ? ");
		String loc = scanner.next();

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // ���� ����ǥ�� 3�� �����ϴ� sql��. �ϼ����Ѿ���...
			// �׷��� ����ǥ 3���� ��� ä����...
			pstmt.setInt(1, deptno); // ù��° ����ǥ�� deptno�� �־���.
			pstmt.setString(2, dname); // �� ��° ����ǥ���� dname�� �־���. Ÿ�� ����!
			pstmt.setString(3, loc); // �׸��� pstmt�� ��� �����?
			int result = pstmt.executeUpdate(); // �̹� pstmt�� sql�� set�� �� prepare�� �Ǿ����Ƿ�, �ȿ��� �ƹ��͵� ���� ���ƾ���.
			System.out.println(result > 0 ? "�Է¼���" : "�Է½���");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
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
