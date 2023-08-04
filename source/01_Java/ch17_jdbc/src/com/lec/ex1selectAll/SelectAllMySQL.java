package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/jangdb?serverTimezone=UTC";
		String sql = "SELECT * FROM PERSONAL"; // ��� ����Ϸ��� �ʿ��� ��

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver); // 1�ܰ�.. ����̹� �ε�
			System.out.println("����̹��ε强��");
			conn = DriverManager.getConnection(url, "root", "mysql");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ");
				while (rs.next()) {
					int pno = rs.getInt("pno"); // ��ȣ ���� Ÿ��Ʋ�̸�, alias�� ���� ���� alias�� ���� ��. (�ʵ��̸����°;ƴ�!)
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					String manager = rs.getString("manager"); // null�� ��� 0.
					Date startdate = rs.getDate("startdate"); // String���� �ص� �ǳ� sdf�� ����� ���� �����Ƿ� date�� ����
					Timestamp startdate1 = rs.getTimestamp("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					if (job.length() >= 8) {
						System.out.printf("%d\t%s\t%s\t%s\t%TF\t%d\t%d\t%d\n",
								pno, pname, job, manager, startdate1, pay, bonus, dno); // �� �� �����Ծ�? �׷� close��!

					} else {
						System.out.printf("%d\t%s\t%s\t\t%s\t%TF\t%d\t%d\t%d\n",
								pno, pname, job, manager, startdate1, pay, bonus, dno);
					}
				}

			} else {
				System.out.println("���� �����ϴ�.");
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (rs != null) // db��������. ��ü �������� ���� �ݴ� ������ ���� ��.
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
