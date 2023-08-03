package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		// driver, url, sql ��ü�� ���� �����ϰ� ���� �־���. �Ʒ����� ���
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM EMP"; // sql ���������� ����. �޴� �����?
		Connection conn = null;
		Statement stmt = null; // �´� import���ְ�, ��ü�� ������ ��. �����ʱ�ȭ
		ResultSet rs = null;
		// ���� ����̺� �ε�, �б�, �ݱ� ������ ��ġ��.
		try {
			Class.forName(driver); // 1. ����̹� �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2. DB�� ����
			stmt = conn.createStatement(); // 3. sql ���۰�ü.
			rs = stmt.executeQuery(sql); // 4. sql�� ������. + 5. ���� ����� ����. (�Ƹ��� emp���̺� 14��)
			// 6. ���� ����� ���� ���ϴ� ����.. (����� ������? ��ϵ� �����Ͱ� �����ϴ� ������ ���)
			// �������� �����? while���� �����ؼ� �ϳ��� ���� �������� ����.
			if (rs.next()) { // rs.next() = true, �� ���� ���� �ִٴ� �ǹ�.
			System.out.println("���\t�̸�\t\t��å\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ"); // Ÿ��Ʋ�� �켱 �Ѹ�
				do {
					int empno = rs.getInt("EMPNO"); // empno��� Ÿ��Ʋ�� �ִ� ���� ������ �ֱ�. alias ��밡��.
					String ename = rs.getString("ENAME");
					String job = rs.getString("JOB");
					String mgr = rs.getString("MGR"); // mgr�� null���� �ִ� ���, int�� 0���� ����.
					// Date hiredate = rs.getDate("HIREDATE"); // ��¥��. �ð��� 0�� 0�� 0�ʷ� �޾���.
					Timestamp hiredate = rs.getTimestamp("HIREDATE"); // �ð��� �����Ͽ� �ް� �ʹٸ�.
					int sal = rs.getInt("SAL");
					int comm = rs.getInt("COMM");
					int deptno = rs.getInt("DEPTNO"); // �� ������ Ÿ��Ʋ�� �ش��ϴ� ���� ��� �Ҵ�.
					if (job.length() >= 6) {
						System.out.printf("%d\t %s\t %s\t %s\t %TF\t %d\t %d\t %d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);					
					} else {
					System.out.printf("%d\t %s\t %s\t\t %s\t %TF\t %d\t %d\t %d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}
					// �׷��� ����ð� ���� �ú��ʸ� �޾ƾ� �� ���� Timestamp�� ����ؾ� ��.
										
				} while (rs.next()); // ���� ���� �ִ� ���� ���ѹݺ�. (rs�� �������� �� ��. (empno,ename,job���...))

			} else { // select�� ����� �� �൵ ���� ���
				System.out.println("��ϵ� ����� �����ϴ�.");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { 
				if (rs != null) rs.close(); //�ݾƾ� �ϴ� �������� �� ������ �ݴ�� ���� ��.
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
