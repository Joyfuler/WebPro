package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// �μ����� �Է¹޾� �ش� �μ� ����� ��� (���, �̸�, ����̸�, �޿�, �޿����, ��� ������ ���� -CEO- ��� ���.
// �޿������� ����)
// �μ����� ������ --> �ش� ������ �����ϴ�.
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT A.EMPNO, A.ENAME, NVL(B.ENAME,'-CEO-') SANGSA, A.MGR, A.SAL, GRADE"
				+ " FROM EMP A, EMP B, DEPT D, SALGRADE" + " WHERE A.SAL BETWEEN LOSAL AND HISAL"
				+ " AND A.MGR=B.EMPNO(+)" + " AND A.DEPTNO = D.DEPTNO" + " AND DNAME = UPPER(?) ORDER BY SAL DESC";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			Class.forName(driver);
			pstmt = conn.prepareStatement(sql);
			System.out.println("ã���� �μ��� �Է����ּ��� : ");
			String dname = scanner.next();
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if (rs.next()) { // �ش� �μ� ��� ����. ����Ʈ���..
				System.out.println("���\t�̸�\t���\t�޿�\t�޿����");
				do {
					int empno = rs.getInt("EMPNO");
					String ename = rs.getString("ENAME");
					String sangsa = rs.getString("SANGSA");
					int sal = rs.getInt("SAL");
					int grade = rs.getInt("GRADE");
					System.out.printf("%d\t%s\t%s\t%d\t%d\n", empno, ename, sangsa, sal, grade);
				} while (rs.next()); //�������� ���� ������ �ݺ��Ͽ� �����͸� �����.

			} else {
				System.out.println("�ش��ϴ� �μ��� �����ϴ�.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
			}

		}
	}
}