package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		// ����Ŭ db������ ���� �۾�... (�ϱ� x) 1. ����, 2. read (db����) 3.�ݱ�. ���� filestream�� ������ ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		// ����Ŭ�� ����̹��� �ִ� ���� �ҷ���.
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// ���� ��������, �߰��� �ּ�, �ڴ� ��Ʈ.
		Connection conn = null; // ��������°� ���������� �켱 null�����ϰ�, ������ �о���� �� ���� ���� ������ (!= null) �ݾ���.
		try {
			Class.forName(driver);
			System.out.println("1. ����̹� �ε� ����");
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2�ܰ�. DB���ᰴü
			System.out.println("2. ����Ŭ ���� ����");
		} catch (ClassNotFoundException e) { // ��Ÿ�� ���ų�, ������ �߸� �Է����� �� ���� ���� ���ܱ���. (try�ȿ� try �� �ֵ��� ����)
			System.out.println("����̹� �ε� ���� : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close(); // �� �о����� DB�� ���� ������ ��! null���� -> �б� -> not null �̸� close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
