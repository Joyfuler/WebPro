package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1; // sql에서 성공했으면 1, 아니면 0으로 출력됨.
	public static final int FAIL = 0;
	private static BoardDao INSTANCE = new BoardDao();

	public static BoardDao getInstance() { // getInstance는 꼭 public static으로!
		return INSTANCE;
	}

	private BoardDao() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 1. 글목록 -> 페이징 처리.. startRow와 endRow가 매개변수로 들어옴.
	public ArrayList<BoardDto> boardList(int startRow, int endRow) {
		ArrayList<BoardDto> lists = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * "+ 
				"FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY BGROUP DESC, BSTEP) A) "+ 
				"WHERE RN BETWEEN ? AND ?"; // 기존 쿼리에 BSTEP ORDER BY 를 추가함. 댓글 정렬기능
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				lists.add(new BoardDto(bid, bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip,
						bdate));
			}
		} catch (SQLException e) {
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
				System.out.println(e.getMessage());
			}
		}
		return lists;
	}

	// -- 2) 전체 글 갯수
	// SELECT COUNT(*) CNT FROM BOARD;
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next(); // count수행시 반드시 1행이 리턴되므로 if나 while을 사용할 필요가 없음.
			totalCnt = rs.getInt("CNT");
		} catch (SQLException e) {
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
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	}

	// -- 3) 원글쓰기 -- 작성자, 글제목, 본문, 이메일, 비밀번호, IP(FROM JAVA) 를 사용자에게 받아 게시글을 등록.
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, BGROUP, BSTEP, BINDENT, BIP) "
				+ "VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, BOARD_SEQ.CURRVAL, 0, 0, ?)";
		// 원글쓰기이므로 BGROUP과 BSTEP은 0으로 고정시켜야 함. 바꾸지 않도록 주의할 것!

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBemail());
			pstmt.setString(5, dto.getBpw());
			pstmt.setString(6, dto.getBip());
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("글작성 완료");
			} else {
				System.out.println("글작성 실패");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("원글쓰다 예외가 발생하였음 : " + dto);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// -- 4) 글보기 - 조회수올리기 (BID 이용)
	public void hitUp(int bid) { // 5번 메소드에서 호출할 예정이므로 리턴할 필요 없음. 함수 수행만
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET BHIT = BHIT+1 WHERE BID =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
			System.out.println(bid + "번 글 조회수 1++");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(bid + "번째 게시글 조회수up 오류발생");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void hitUp(String bid) { // 5번 메소드에서 호출할 예정이므로 리턴할 필요 없음. 함수 수행만
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET BHIT = BHIT+1 WHERE BID =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			pstmt.executeUpdate();
			System.out.println(bid + "번 글 조회수 1++");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(bid + "번째 게시글 조회수up 오류발생");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// UPDATE BOARD SET BHIT = BHIT+1 WHERE BID = 1;
	public BoardDto getContent(String bid) {
		hitUp(bid); // 글 상세보기 시 조회수가 자동으로 1 올라갈 것.
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto = new BoardDto(Integer.parseInt(bid), bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep,
						bindent, bip, bdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// -- 6) 글수정/답변글 - BID로 DTO 가져오기 (글수정FORM, 답변글FORM 이용시 사용), 조회수 올리기 사용 X
	// SELECT * FROM BOARD WHERE BID = 1;
	public BoardDto getBoardNothitup(int bid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto = new BoardDto(bid, bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate);
			}
		} catch (SQLException e) {
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
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}

	public BoardDto getBoardNothitup(String bid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dto = new BoardDto(Integer.parseInt(bid), bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate);
			}
		} catch (SQLException e) {
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
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	
	
	// -- 7) 글수정 (작성자, 글제목, 본문, 이메일, 비밀번호 수정가능)
	public int modifyBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD " + "SET BNAME = ?, " + "BTITLE = ?, " + "BCONTENT = ?, " + "BEMAIL = ?, "
				+ "BPW = ?, " + "BIP = ? " + "WHERE BID = ?";
		// 원글쓰기이므로 BGROUP과 BSTEP은 0으로 고정시켜야 함. 바꾸지 않도록 주의할 것!
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBemail());
			pstmt.setString(5, dto.getBpw());
			pstmt.setString(6, dto.getBip());
			pstmt.setInt(7, dto.getBid());
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("답변글작성 완료");
			} else {
				System.out.println("답변글작성 실패");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("답변글쓰다 예외가 발생하였음 : " + dto);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// UPDATE BOARD
	// SET BNAME = '홍스길스동스',
	// BTITLE = '바꾼제목',
	// BCONTENT = '바꾼본문',
	// BEMAIL = 'H@H.COM',
	// BPW = '111',
	// BIP = '127.0.0.1'
	// WHERE BID = 1;

	// --8) 글삭제 (비밀번호를 맞게 입력한 경우에만 삭제됨)
	// DELETE FROM BOARD WHERE BID = 1 AND BPW = '111';
	public int deleteBoard(int bid, String bpw) { // 글번호와 함꼐 비밀번호 입력도 필요.
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE BID = ? AND BPW = ?";
		// 원글쓰기이므로 BGROUP과 BSTEP은 0으로 고정시켜야 함. 바꾸지 않도록 주의할 것!
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.setString(2, bpw);
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("글삭제완료");
			} else {
				System.out.println("글삭제 실패");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("글삭제중 예외가 발생하였음 : " + bid + "," + bpw);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 9번. 답변글 저장 전단계 - BSTEP 조정 (A단계)
	private void preReplyStep(int bgroup, int bstep){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET BSTEP = BSTEP+ 1 WHERE BGROUP=? AND BSTEP > ?";		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			int cnt = pstmt.executeUpdate();
			System.out.println("기존 답변글 " + cnt + "개 bstep 조정됨");			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	//답변글 달기. 
	// 사용자에게 받아야 하는 정보는 bname, btitle, bcontent, bemail, bpw
	// 원글의 정보 bgroup, bstep, bindent를 dto에 가져옴. 
	// 댓글은 원글의 정보에 update해야함.
	public int reply(BoardDto dto) {
		int result = FAIL;
		preReplyStep(dto.getBgroup(), dto.getBstep()); //원글의 dto정보호출
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, BGROUP, BSTEP, BINDENT, BIP) " + 
				"VALUES (BOARD_SEQ.NEXTVAL, ?, ? , ? , ? , ? , ? , ? , ?, ?)";
		// // 답변글이므로 원글과는 달리 bgroup, bstep, bindent를 모두 따로 받아야 함.
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBemail());
			pstmt.setString(5, dto.getBpw());
			pstmt.setInt(6, dto.getBgroup());
			pstmt.setInt(7, dto.getBstep()+1);
			// bstep에는 +1을 해줘야 함. getbstep은 원글 그대로
			pstmt.setInt(8, dto.getBindent()+1);
			// bindent역시 원글에 +1을 해 줘야 함.
			pstmt.setString(9, dto.getBip());
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("글작성 완료");
			} else {
				System.out.println("글작성 실패");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("원글쓰다 예외가 발생하였음 : " + dto);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
}