package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		// 오라클 db연동을 위한 작업... (암기 x) 1. 연다, 2. read (db연결) 3.닫기. 기존 filestream과 동일한 절차
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 오라클의 드라이버가 있는 곳을 불러옴.
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// 앞은 프로토콜, 중간은 주소, 뒤는 포트.
		Connection conn = null; // 파일입출력과 마찬가지로 우선 null설정하고, 파일을 읽어들인 뒤 읽은 값이 있으면 (!= null) 닫아줌.
		try {
			Class.forName(driver);
			System.out.println("1. 드라이버 로드 성공");
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2단계. DB연결객체
			System.out.println("2. 오라클 연결 성공");
		} catch (ClassNotFoundException e) { // 오타가 났거나, 계정을 잘못 입력했을 때 등을 위한 예외구문. (try안에 try 안 넣도록 주의)
			System.out.println("드라이버 로드 실패 : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close(); // 다 읽었으면 DB를 연결 해제할 것! null설정 -> 읽기 -> not null 이면 close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
