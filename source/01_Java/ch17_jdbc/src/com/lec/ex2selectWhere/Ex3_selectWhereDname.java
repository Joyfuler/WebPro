package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//����ڷκ��� �μ����� ����Ϸ���?
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("����� ���ϴ� �μ����� �Է����ּ���. : ");
		String dname2 = scanner.nextLine();
		String sql = "SELECT * FROM DEPT WHERE DNAME =  UPPER('" + dname2 + "')";
		sql = String.format("SELECT * FROM DEPT WHERE DNAME= UPPER('%s')", dname2);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println("����� ���ϴ� �μ� ������ ������ �����ϴ�.");
				System.out.println("�μ��� : " + dname);
				System.out.println("�μ���ġ : " + loc);
			} else {
				System.out.println("�Է��Ͻ� " + dname2 + " ��(��) �������� �ʽ��ϴ�.");
			}

		} catch (ClassNotFoundException e) {
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