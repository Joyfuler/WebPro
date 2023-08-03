package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
	public static void main(String[] args) {
		
		String driver = "com.mysql.cj.jdbc.Driver"; // .class ����..
		String url = "jdbc:mysql://127.0.0.1:3306/jangdb?serverTimezone=UTC";
		// ���� ��������, �߰��� ��Ʈ, �ڴ� db �̸�. jangdb
		Connection conn = null; // ��������°� ���������� �켱 null�����ϰ�, ������ �о���� �� ���� ���� ������ (!= null) �ݾ���.
		try {
			Class.forName(driver);
			System.out.println("1. ����̹� �ε� ����");
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2�ܰ�. DB���ᰴü(DriverManager.getConnection(���̵���)
			System.out.println("2. mysql ���� ����");
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
