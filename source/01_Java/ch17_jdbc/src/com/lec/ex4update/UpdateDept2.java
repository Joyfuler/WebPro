package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ������ �μ���ȣ�� �޾� ���� ���θ� Ȯ���ϰ�, �μ���, �ٹ����� �Է¹޾� update
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.println("������ �μ� ��ȣ��? : ");
			int deptno = scanner.nextInt();
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno; // �� ��� ����� �� �����⵵ ��. next�� �Ǵ��ؾ�
			rs = stmt.executeQuery(selectSQL);
			if (rs.next()) { // �����ϴ� �μ� ��ȣ�̹Ƿ� ���� ����
				System.out.println("������ �μ�����? : ");
				String dname = scanner.next();
				System.out.println("������ ��ġ��? : ");
				String loc = scanner.next();
				String updateSQL = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO=%d", dname, loc,
						deptno);
				// ������ �ߺ�üũ�� �����Ͽ����Ƿ�, �Ʒ����� ���� üũ���� �ʰ� update�ϸ� ��.
				int result = stmt.executeUpdate(updateSQL);
				if (result > 0) {
					System.out.println("��������!");
				}

			} else {
				System.out.println(deptno + "�� �μ��� ��ȿ�� �μ� ��ȣ�� �ƴմϴ�.");				

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

		}

	}
}
