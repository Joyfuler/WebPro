package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ������ �μ���ȣ�� �μ���, �ٹ����� �Է¹޾� update ����
public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		// �켱 scanner�� ���� update�� ���� �������� �޾Ƶд�.
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �μ���ȣ�� ? (���ڵ��ڸ�) : ");
		int deptno = scanner.nextInt();
		// �μ���ȣ�� ���� Ȯ��
		System.out.println("������ �μ����� ? (4�����̳�) : ");
		String dname = scanner.next();
		System.out.println("������ �μ��� ��ġ�� ? : ");
		String loc = scanner.next();
		String sql = String.format("UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO=?");

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, deptno);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			int result = pstmt.executeUpdate(); // 1�� ������Ʈ? 0�� ������Ʈ?
			System.out.println(result > 0 ? deptno + "�� �μ� ������" : deptno + "�� �μ��� ���� ���� �Ұ�");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("�ʹ� ��ų� �߸��Է��ؼ� ����" + e.getMessage());
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

	}
}
