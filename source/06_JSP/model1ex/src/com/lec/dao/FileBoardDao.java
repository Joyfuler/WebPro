package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lec.dto.CustomerDto;
import com.lec.dto.FileBoardDto;


// 커넥션풀 이용, 싱글톤
public class FileBoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static FileBoardDao INSTANCE = new FileBoardDao();

	public static FileBoardDao getInstance() {
		return INSTANCE;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 1. 게시판 전체리스트 출력 (paging)
	public ArrayList<FileBoardDto> csBoardList(int startRow, int endRow) {
		ArrayList<FileBoardDto> lists = new ArrayList<FileBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, F.* FROM "
				+ "(SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP) F, CUSTOMER C WHERE F.CID=C.CID) "
				+ "WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FileBoardDto dto = new FileBoardDto();
				dto.setFid(rs.getInt("fid"));
				dto.setCid(rs.getString("cid"));
				dto.setFtitle(rs.getString("ftitle"));
				dto.setFcontent(rs.getString("fcontent"));
				dto.setFilename(rs.getString("filename"));
				dto.setFhit(rs.getInt("fhit"));
				dto.setFpw(rs.getString("fpw"));
				dto.setFgroup(rs.getInt("fgroup"));
				dto.setFstep(rs.getInt("fstep"));
				dto.setFindent(rs.getInt("findent"));
				dto.setFip(rs.getString("fip"));
				dto.setFrdate(rs.getDate("frdate"));
				lists.add(dto);
			}
		} catch (Exception e) {
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
	// 2. 게시글 전체갯수 출력 (페이징용)
	public int getTotalCntcsBoard() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt("CNT");
		} catch (Exception e) {
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
		return result;		
	}	
	
	// 3. 게시판에 글쓰기  
	public int WritecsBoard(FileBoardDto dto) {
		int result = FAIL;	
		Connection conn = null;
		PreparedStatement pstmt = null;	
		String sql = "INSERT INTO FILEBOARD (FID,CID,FTITLE,FCONTENT,FILENAME,FPW,FGROUP,FSTEP,FINDENT,FIP,FRDATE) "
			+ "VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ? , ? , ? , ? ,FILEBOARD_SEQ.CURRVAL, 0 , 0 ,? , SYSDATE)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setString(6, dto.getFip());			
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("입력완료");							
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("입력실패");
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
	
	// 3-2. 게시판 조회수 올리기 (상세보기시 사용)
	public void hitup(String fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT+1 WHERE FID =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fid);
			pstmt.executeUpdate();
			System.out.println(fid + "번 글 조회수 1++");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(fid + "번째 게시글 조회수up 오류발생");
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
	
	// 4. 게시판 글내용 상세보기 (fid로 dto 가져오기)
	public FileBoardDto csBoardDetail(String fid) {
		hitup(fid);
		FileBoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT C.*, F.* FROM CUSTOMER C, FILEBOARD F WHERE C.CID=F.CID AND F.FID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fid);			
			rs = pstmt.executeQuery();
			while (rs.next()) {				
				// fid
				String cid = rs.getString("cid");
				String cemail = rs.getString("cemail");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");				
				String filename = rs.getString("filename");
				int fhit = rs.getInt("fhit");
				String fpw = rs.getString("fpw");				
				int fgroup =rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				Date frdate = rs.getDate("frdate");
				dto = new FileBoardDto(Integer.parseInt(fid),cid,cemail,ftitle,fcontent,filename,fhit,fpw,fgroup,fstep,findent,fip,frdate);
			}
		} catch (Exception e) {
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
	
	// 5. 게시판 글수정
	public int modifycsBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;	
		String sql = "UPDATE FILEBOARD SET FTITLE = ? , FCONTENT = ?, " 
				+ "FILENAME = ?, FPW = ? WHERE FID= ?";		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, dto.getFtitle());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setInt(5, dto.getFid());			
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("입력완료");							
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("입력실패");
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
	
	// 6. 게시판 글삭제
	public int removecsBoard(String cid, String fpw) {
	int result = FAIL;
	Connection conn = null;
	PreparedStatement pstmt = null;	
	String sql = "DELETE FROM FILEBOARD WHERE CID = ? AND FPW = ?";		
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cid);
		pstmt.setString(2, fpw);
		result = pstmt.executeUpdate();
		if (result == SUCCESS) {
			System.out.println("삭제완료");	
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("삭제실패");
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
		private void preReplyStep(int fgroup, int fstep){
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP+ 1 WHERE FGROUP=? AND FSTEP > ?";		
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fgroup);
				pstmt.setInt(2, fstep);
				int cnt = pstmt.executeUpdate();
				System.out.println("기존 답변글 " + cnt + "개 fstep 조정");			
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
		
		public int replycsBoard(FileBoardDto dto) {
			int result = FAIL;
			preReplyStep(dto.getFgroup(), dto.getFstep()); //원글의 dto정보호출
			Connection conn = null;
			PreparedStatement pstmt = null;			
			String sql = "INSERT INTO FILEBOARD (FID,CID,FTITLE,FCONTENT,FILENAME,FPW,FGROUP,FSTEP,FINDENT,FIP,FRDATE) "
					+ "VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ? ,? ,?, ? ,?, ? ,?, SYSDATE)";			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCid());
				pstmt.setString(2, dto.getFtitle());
				pstmt.setString(3, dto.getFcontent());
				pstmt.setString(4, dto.getFilename());
				pstmt.setString(5, dto.getFpw());
				pstmt.setInt(6, dto.getFgroup());
				pstmt.setInt(7, dto.getFstep()+1);
				pstmt.setInt(8, dto.getFindent()+1);				
				pstmt.setString(9, dto.getFip());				
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
	
	
