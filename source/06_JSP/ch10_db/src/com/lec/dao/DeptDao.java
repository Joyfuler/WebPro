package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lec.dto.DeptDto;

public class DeptDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	private static DeptDao INSTANCE = null; // instance객체는 DeptDao와 동일하게 설정!

	public static DeptDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DeptDao();
		}
		return INSTANCE;
	}

	private DeptDao() {
		try {
			Class.forName(driver); // 클래스 내에서 한번만 실행하면 되므로 기본생성자함수에서 실행하였음.

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ArrayList<DeptDto>를 반환하는 기능을 가진 deptList 메소드(deptdto타입 arraylist)
	public ArrayList<DeptDto> deptList() {
		ArrayList<DeptDto> dtos = new ArrayList<DeptDto>();
		// 만일 값이 아예 없는 경우에는 비어있는 arraylist라도 반환. 이후 db와 연동 시작
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // stmt는 마지막 실행할 때, pstmt는 준비할때 우선 sql을 넣자
			while (rs.next()) {
				// 데이터가 없다면 비어있는 dtos를 반환, 있다면 배열로 되어 있는 dtos를 반환함.
				// 이후 dtos를 받은 곳에서 길이를 재고, 만일 데이터가 없다면 '없음' 표시
				DeptDto dto = new DeptDto(); // 빈 객체를 우선 생성하는 새로운 방법. !!반드시 while 안에 넣을 것
				dto.setDetpno(rs.getInt("deptno")); //rs로 가져온 값을 dto로 세팅함.
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));			
				dtos.add(dto);
//				int deptno = rs.getInt("deptno");
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				dtos.add(new DeptDto(deptno, dname, loc)); // 데이터를 가져온 후, 배열에 추가함.
				// add시에는 꼭 새로운 객체를 만들자 (new DeptDto)
			}
		} catch (SQLException e) {
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
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	
	
	
	
}
