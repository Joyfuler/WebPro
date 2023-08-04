package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �Է¹��� �μ���ȣ�� �ߺ� üũ�� �� �μ���, ��ġ�� �Է¹޾� insert��
public class Ex2_InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) cnt from dept where deptno = ?";
		String sql2 = "insert into dept values (?, ?, ?)";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			System.out.println("�߰��ϰ� ���� �μ���ȣ�� �Է��ϼ���");
			int deptno = scanner.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next(); // 1�� ���.
			int cnt = rs.getInt("cnt");
			if (cnt != 0) {
				System.out.println("�̹� �ִ� �μ���ȣ�� ������ �� ����");
			} else { // �ߺ�üũ �Ϸ�������, ������ �Է��� �� �ʿ�.
				rs.close();
				pstmt.close(); // ���� �ݱ� ����!! �ٽ� ���� �ٽ� ����
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, deptno);
				System.out.println("�߰��ϰ� ���� �μ����� �Է��ϼ���");
				pstmt.setString(2, scanner.next());
				System.out.println("�߰��ϰ� ���� ��Ҹ� �Է��ϼ���");
				pstmt.setString(3, scanner.next());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					System.out.println("�μ� ���� �Ϸ�");
				} else {
					System.out.println("�μ� ���� ����");
				}
			}

//			System.out.println("�߰��ϰ� ���� �μ����� �Է��ϼ���");
//			pstmt.setString(2,scanner.next());
//			System.out.println("�߰��ϰ� ���� ��ġ�� �Է��ϼ���");
//			pstmt.setString(3,scanner.next());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	}
}
