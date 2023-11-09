package com.lec.ch11.daovo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository
public class BoardmvcDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	private static BoardmvcDao INSTANCE = null;

	public static BoardmvcDao getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new BoardmvcDao();
		}
		return INSTANCE;
	}
	
	// 1. 글목록출력 (startRow, endRow)
	public ArrayList<BoardmvcDto> listBoard(final int startRow, final int endRow) {				
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM "
				+ "(SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A) " 
				+ "WHERE RN BETWEEN ? AND ?";
		return (ArrayList<BoardmvcDto>) jdbcTemplate.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, startRow);
				ps.setInt(2, endRow);						
			}
		}, new BeanPropertyRowMapper<BoardmvcDto>(BoardmvcDto.class));
	}

	// 2. 글갯수 가져오기
	public int BoardtotCount() {		
		String sql = "SELECT COUNT(*) CNT FROM MVC_BOARD";
		int totCnt = jdbcTemplate.queryForObject(sql, Integer.class);
		return totCnt;
	}

	// 3. 원글작성 (
	public int writeBoard(final BoardmvcDto dto) {		
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				+ "VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, dto.getBname());
				pstmt.setString(2, dto.getBtitle());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setString(4, dto.getBip());				
			}
		});	
	}
	
	// 5. bid로 조회수 1 올리기
	public void hitup(int bid) {
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID = " + bid;
		jdbcTemplate.update(sql);			
	}

	// 6. bid로 게시글 dto 가져오기 (글조회수up x)
	public BoardmvcDto getBoardInfo(int bid) {	
		String sql = "SELECT * FROM MVC_BOARD WHERE BID = " + bid;
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<BoardmvcDto>(BoardmvcDto.class));
	}

	// 7. 글수정 (특정 bid를 가져와 bname, btitle, bcontent, bip 수정)
	public int updateBoard(final BoardmvcDto dto) {	
		String sql = "UPDATE MVC_BOARD SET BNAME = ?, BTITLE = ?, BCONTENT = ?, BIP = ? " + "WHERE BID = ?";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, dto.getBname());
				pstmt.setString(2, dto.getBtitle());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setString(4, dto.getBip());
				pstmt.setInt(5, dto.getBid());				
			}
		});			
	}
	
	// 9. 글삭제
	public int deleteBoard(int bid) {
		String sql = "DELETE FROM MVC_BOARD WHERE BID = " + bid;
		return jdbcTemplate.update(sql);
	}

	// 10. 답변글 저장 전단계
	private void preReplyStep(final int bgroup, final int bstep) {	
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP +1 " + "WHERE BGROUP = ? AND BSTEP > ?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bgroup);
				pstmt.setInt(2, bstep);				
			}
		});			
	}

	// 11. 답변글 저장
	public int replyBoard(final BoardmvcDto dto) {		
		preReplyStep(dto.getBgroup(), dto.getBstep());		
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BDATE, BHIT, BGROUP, BSTEP, BINDENT, BIP) "
				+ "VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, SYSDATE, 0, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, dto.getBname());
				pstmt.setString(2, dto.getBtitle());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setInt(4, dto.getBgroup());
				pstmt.setInt(5, dto.getBstep() + 1);
				pstmt.setInt(6, dto.getBindent() + 1);
				pstmt.setString(7, dto.getBip()); 				
			}
		});		
	} // replyboard
} // class
