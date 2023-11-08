package com.lec.ch10.daovo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class BoardmvcDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public DataSource ds;
	private static BoardmvcDao INSTANCE = null;

	public static BoardmvcDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BoardmvcDao();
		}
		return INSTANCE;
	}
	public BoardmvcDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1. 글목록출력 (startRow, endRow)
	public ArrayList<BoardmvcDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardmvcDto> list = new ArrayList<BoardmvcDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM "
				+ "(SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A) " + "WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				list.add(new BoardmvcDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
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
		return list;
	}

	// 2. 글갯수 가져오기
	public int BoardtotCount() {
		int boardCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MVC_BOARD";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			boardCnt = rs.getInt("CNT");
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
		return boardCnt;
	}

	// 3. 원글작성 (
	public int writeBoard(BoardmvcDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				+ "VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBip());
			pstmt.executeUpdate();
			result = SUCCESS;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("원글쓰기 실패");
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
	// 4. 글작성
	public int writeBoard(String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				+ "VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.executeUpdate();
			result = SUCCESS;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("원글쓰기 실패");
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

	// 5. bid로 조회수 1 올리기
	public void hitup(int bid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
			System.out.println(bid + "번글 조회수 up");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(bid + "번 글 조회수 up 실패");
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

	// 6. bid로 게시글 dto 가져오기 (글조회수up x)
	public BoardmvcDto getBoardInfo(int bid) {
		BoardmvcDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Date bdate = rs.getDate("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dto = new BoardmvcDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
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

	// 7. 글수정 (특정 bid를 가져와 bname, btitle, bcontent, bip 수정)
	public int updateBoard(BoardmvcDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BNAME = ?, BTITLE = ?, BCONTENT = ?, BIP = ? " + "WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBip());
			pstmt.setInt(5, dto.getBid());
			result = pstmt.executeUpdate();
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
		return result;
	}
	// 8. 글수정
	public int updateBoard(int bid, String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BNAME = ?, BTITLE = ?, BCONTENT = ?, BIP = ? " + "WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.setInt(5, bid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글수정성공" : "글번호오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + ":글수정실패");
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

	// 9. 글삭제
	public int deleteBoard(int bid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC_BOARD WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글삭제완료" : "글bid번호오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글삭제실패");
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

	// 10. 답변글 저장 전단계
	private void preReplyStep(int bgroup, int bstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP +1 " + "WHERE BGROUP = ? AND BSTEP > ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 개 bstep 재조정됨");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + ": preReplyStep 오류");
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

	// 11. 답변글 저장
	public int replyBoard(BoardmvcDto dto) {
		int result = FAIL;
		preReplyStep(dto.getBgroup(), dto.getBstep());
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				+ "VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, SYSDATE, 0, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setInt(4, dto.getBgroup());
			pstmt.setInt(5, dto.getBstep() + 1);
			pstmt.setInt(6, dto.getBindent() + 1);
			pstmt.setString(7, dto.getBip());
			result = pstmt.executeUpdate();
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
		return result;
	}
	
	// 11. 답변글 저장 (dto대신 하나씩 받기)
	public int replyBoard(String bname, String btitle, String bcontent, String bip, int bgroup, int bstep,
			int bindent) {
		int result = FAIL;
		preReplyStep(bgroup, bstep);
		// 원글의 bgroup과 bstep을 받고 답변글이 있다면 모두 bstep이 +1씩 증가함.
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				+ "VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, SYSDATE, 0, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep + 1);
			pstmt.setInt(6, bindent + 1);
			pstmt.setString(7, bip);
			result = pstmt.executeUpdate();
			System.out.println("답변글 쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변글작성실패");
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
