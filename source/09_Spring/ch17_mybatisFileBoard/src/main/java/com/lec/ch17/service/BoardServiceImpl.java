package com.lec.ch17.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch17.repository.BoardDao;
import com.lec.ch17.util.Paging;
import com.lec.ch17.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;	
	private Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public List<Board> boardList(Paging paging) {
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}

	@Override
	public int getBoardTotCnt() {
		return boardDao.getBoardTotCnt();
	}

	@Override
	public int boardWrite(MultipartHttpServletRequest mRequest, Board board,  HttpServletRequest request) {
		
		String uploadPath = mRequest.getRealPath("upload/");
		String backUpPath = "D:\\webPro\\source\\09_Spring\\ch17_mybatisFileBoard\\src\\main\\webapp\\upload\\";
		String fileName = "";		
		Iterator<String> params = mRequest.getFileNames(); 		
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			fileName = mFile.getOriginalFilename();
			logger.info(
					fileName == null ? "파일없음" : fileName.equals("") ? "첨부안함" : "첨부 파일 이름은" + fileName);
			// 만일 첨부한 이미지가 이미 서버에 있다면, 덮어씌워선 안 됨
			if (fileName!= null && !fileName.equals("")) {
				// 첨부했다면 서버에 동일한 파일이 있는지를 확인
				if (new File(uploadPath + fileName).exists()) {
					// true라면 이미 서버에 동일한 이름의 파일이 존재한 것. 파일 이름 변경 필요
					// 현재 시간을 대입해 넣을 수 있음.
					fileName = System.currentTimeMillis() + "_" + fileName;
				}
				try {
					mFile.transferTo(new File(uploadPath + fileName));				
					logger.info("서버에 저장된 파일 : " + uploadPath + fileName);
					logger.info("복사될 파일 :" + backUpPath + fileName);
					int result = filecopy(uploadPath + fileName, backUpPath + fileName);
					System.out.println(result==1 ? "백업완료":"백업에러");
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			} else {
				// 첨부를 안 했다면 서버로 파일 카피를 수행하지 않음.
			}
		board.setBfile(fileName);
		board.setBip(request.getRemoteAddr());		
		return boardDao.boardWrite(board);		
	}
	
	private int filecopy(String serverFile, String backupFile) {
		int result = 0;
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] bs = new byte[(int) (file.length())]; // 파일 길이만큼의 bs라는 배열을 만듬. int 형변환 필요 (배열크기는 21억을 넘지 못하므로)
			while (true) {
				int readBytes = is.read(bs);
				if (readBytes == -1) {
					break; // 모두 읽으면 -1이 되므로 멈춘다.
				}
				os.write(bs, 0, readBytes);
				result = 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}	

	@Override
	public Board boardContent(int bid, String after) {
		if (after == null) {
			boardDao.boardHitUp(bid);
		}
		return boardDao.getBoardDto(bid);
	}

	@Override
	public Board boardModifyReplyView(int bid) {
		return boardDao.getBoardDto(bid);
	}

	@Override
	public int boardModify(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request) {		
		String uploadPath = mRequest.getRealPath("upload/");
		String backUpPath = "D:\\webPro\\source\\09_Spring\\ch17_mybatisFileBoard\\src\\main\\webapp\\upload\\";
		String fileName = "";		
		Iterator<String> params = mRequest.getFileNames(); 		
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			fileName = mFile.getOriginalFilename();
			logger.info(
					fileName == null ? "파일없음" : fileName.equals("") ? "첨부안함" : "첨부 파일 이름은" + fileName);
			// 만일 첨부한 이미지가 이미 서버에 있다면, 덮어씌워선 안 됨
			if (fileName!= null && !fileName.equals("")) {
				// 첨부했다면 서버에 동일한 파일이 있는지를 확인
				if (new File(uploadPath + fileName).exists()) {
					// true라면 이미 서버에 동일한 이름의 파일이 존재한 것. 파일 이름 변경 필요
					// 현재 시간을 대입해 넣을 수 있음.
					fileName = System.currentTimeMillis() + "_" + fileName;
				}
				try {
					mFile.transferTo(new File(uploadPath + fileName));				
					logger.info("서버에 저장된 파일 : " + uploadPath + fileName);
					logger.info("복사될 파일 :" + backUpPath + fileName);
					int result = filecopy(uploadPath + fileName, backUpPath + fileName);
					System.out.println(result==1 ? "백업완료":"백업에러");
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			} else {
				// 첨부를 안 했다면 서버로 파일 카피를 수행하지 않음.
			}
		board.setBfile(fileName);
		board.setBip(request.getRemoteAddr());		
		return boardDao.boardModify(board);		
	}
	

	@Override
	public int boardDelete(int bid) {
		return boardDao.boardDelete(bid);
	}

	@Override
	public int boardReply(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request) {
		String uploadPath = mRequest.getRealPath("upload/");
		String backUpPath = "D:\\webPro\\source\\09_Spring\\ch17_mybatisFileBoard\\src\\main\\webapp\\upload\\";
		String fileName = "";		
		Iterator<String> params = mRequest.getFileNames(); 		
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			fileName = mFile.getOriginalFilename();
			logger.info(
					fileName == null ? "파일없음" : fileName.equals("") ? "첨부안함" : "첨부 파일 이름은" + fileName);
			// 만일 첨부한 이미지가 이미 서버에 있다면, 덮어씌워선 안 됨
			if (fileName!= null && !fileName.equals("")) {
				// 첨부했다면 서버에 동일한 파일이 있는지를 확인
				if (new File(uploadPath + fileName).exists()) {
					// true라면 이미 서버에 동일한 이름의 파일이 존재한 것. 파일 이름 변경 필요
					// 현재 시간을 대입해 넣을 수 있음.
					fileName = System.currentTimeMillis() + "_" + fileName;
				}
				try {
					mFile.transferTo(new File(uploadPath + fileName));				
					logger.info("서버에 저장된 파일 : " + uploadPath + fileName);
					logger.info("복사될 파일 :" + backUpPath + fileName);
					int result = filecopy(uploadPath + fileName, backUpPath + fileName);
					System.out.println(result==1 ? "백업완료":"백업에러");
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			} else {
				// 첨부를 안 했다면 서버로 파일 카피를 수행하지 않음.
			}
		board.setBfile(fileName);
		board.setBip(request.getRemoteAddr());		
		return boardDao.boardReply(board);		
	}

	@Override
	public void dummyData70Write() {
		Board board = new Board();
		for (int i = 1; i < 70; i++) {
			board.setBname("홍길동"+i);
			board.setBtitle("제목"+i);
			board.setBip("192.168.1."+i);
			int result = boardDao.boardWrite(board);
			System.out.println(result ==1? i+"번째 글 작성완료": i+"번째 글 작성실패");
		}
	}
}