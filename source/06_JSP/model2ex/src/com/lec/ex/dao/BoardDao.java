package com.lec.ex.dao;

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

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public DataSource ds;
	private static BoardDao INSTANCE = null;

	public static BoardDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BoardDao();
		}
		return INSTANCE;
	}
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// (1) 게시글리스트 출력 (작성자 출력을 위한 equi join)
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.*, M.MNAME FROM "
				+ "(SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP) A, "
				+ "MVC_MEMBER M WHERE A.MID = M.MID) WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("Fid");
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				Date frdate = rs.getDate("frdate");
				String ffilename = rs.getString("ffilename");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				String mid = rs.getString("mid");
				list.add(new BoardDto(fid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip, mid, mname));
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
	
	// (2) 페이징 처리를 위한 총 게시글 갯수 구하기
	public int BoardtotCount() {
		int boardCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD";
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
	
	// (3) 게시글 원글작성
	public int writeBoard(String ftitle, String fcontent, String ffilename, String fip, String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, FTITLE,FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP, MID)" + 
			    "VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, 0, FILEBOARD_SEQ.CURRVAL, 0, 0, ?, ?)";    
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ftitle);
			pstmt.setString(2, fcontent);
			pstmt.setString(3, ffilename);
			pstmt.setString(4, fip);
			pstmt.setString(5, mid);
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
	
	// (4) hit 1회 올리기
	public void hitup(int fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
			System.out.println(fid + "번글 조회수 up");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(fid + "번 글 조회수 up 실패");
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
	
	// (5) fid로 게시글 전체 정보 (dto) 가져오기
	public BoardDto getBoardInfo(int fid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, M.MNAME FROM FILEBOARD F, "
				+ "MVC_MEMBER M WHERE F.MID = M.MID AND FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if (rs.next()) {				
				String mname = rs.getString("mname");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				Date frdate = rs.getDate("frdate");
				String ffilename = rs.getString("ffilename");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				String mid = rs.getString("mid");
				dto = new BoardDto(fid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip, mid, mname);
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
	
	// (6) 글 수정하기
	public int updateBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FTITLE = ?, FCONTENT = ?, FFILENAME = ?, FIP = ? WHERE FID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFtitle());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFip());
			pstmt.setInt(5, dto.getFid());
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
	
	// (7) 글 삭제하기 (답변글까지 삭제)
	public int deleteBoard(int fid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID= ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글삭제완료" : "글fid번호오류");
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
		
	// 8) 답변글 저장 전단계
		private void preReplyStep(int fgroup, int fstep) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP +1 " + "WHERE FGROUP = ? AND FSTEP > ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fgroup);
				pstmt.setInt(2, fstep);
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
	// (9) 답변글저장
		public int replyBoard(BoardDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO FILEBOARD (FID, FTITLE, FCONTENT, FFILENAME, FRDATE, FHIT, FGROUP, FSTEP, FINDENT, FIP, MID) "
					+ "VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, SYSDATE, 0, ?, ?, ?, ?)";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, dto.getFid());
				pstmt.setString(2, dto.getFtitle());
				pstmt.setString(3, dto.getFcontent());
				pstmt.setString(4, dto.getFfilename());
				pstmt.setInt(5, dto.getFstep() + 1);
				pstmt.setInt(6, dto.getFindent() + 1);
				pstmt.setString(7, dto.getFip());
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
		
		// 10) 회원탈퇴 - 탈퇴회원 쓴 글 모두삭제 
		public int removeAll (String mid) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM FILEBOARD WHERE MID = ?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				result = pstmt.executeUpdate();
				System.out.println(mid + "회원의 게시글"+ result + "개 삭제완료");
			} catch (SQLException e) {
				System.out.println(e.getMessage() + mid + "회원 게시글 삭제실패");				
			} finally {				
					try {
						if (pstmt != null) pstmt.close();
						if (conn != null)
						conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}				
			}			
			return result;			
		}
	}
