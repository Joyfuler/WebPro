package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.repository.BookDao;
import com.lec.ch19.util.Paging;
import com.lec.ch19.vo.Book;

@Service
public class BookServiceimpl implements BookService {
	@Autowired
	public BookDao bookDao;
	
	Logger logger = LoggerFactory.getLogger(BookServiceimpl.class); 

	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(Book book, String pageNum) {		
		Paging paging = new Paging(bookDao.totCntBook(book), pageNum, 5, 5);
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.bookList(book);
	}	

	@Override
	public int totCntBook(Book book) {
		return bookDao.totCntBook(book);
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		int uploaded = 0;
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		String backUpPath = "D:\\webPro\\source\\09_Spring\\ch19_bookUpMember\\src\\main\\webapp\\bookImgFileUpload\\";
		String[] fileNames = new String[2];
		int idx = 0;
		Iterator<String> params = mRequest.getFileNames();		
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			fileNames[idx] = mFile.getOriginalFilename();
			if (fileNames[idx] != null && !fileNames[idx].equals("")) {
				if (new File(uploadPath + fileNames[idx]).exists()) {
					fileNames[idx] = System.currentTimeMillis() + "_" + fileNames[idx];					
				}				
				try {
					mFile.transferTo(new File(uploadPath + fileNames[idx]));
					uploaded = filecopy(uploadPath + fileNames[idx], backUpPath + fileNames[idx]);
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}			
			} else {
				
			}			
			idx++;			
		}
		book.setBimg1(fileNames[0]);
		book.setBimg2(fileNames[1]);
		return bookDao.registerBook(book);
	}

	private int filecopy(String serverFile, String backupFile) {
		int isCopy = 0;
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
				isCopy = 1;
			}
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
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
		return isCopy;
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		int uploaded = 0;
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		String backUpPath = "D:\\webPro\\source\\09_Spring\\ch19_bookUpMember\\src\\main\\webapp\\bookImgFileUpload\\";
		String[] fileNames = new String[2];
		int idx = 0;
		Iterator<String> params = mRequest.getFileNames();		
		while (params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			fileNames[idx] = mFile.getOriginalFilename();
			if (fileNames[idx] != null && !fileNames[idx].equals("")) {
				if (new File(uploadPath + fileNames[idx]).exists()) {
					fileNames[idx] = System.currentTimeMillis() + "_" + fileNames[idx];					
				}				
				try {
					mFile.transferTo(new File(uploadPath + fileNames[idx]));
					uploaded = filecopy(uploadPath + fileNames[idx], backUpPath + fileNames[idx]);
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}			
			} else {
				
			}			
			idx++;			
		}
		book.setBimg1(fileNames[0]);
		book.setBimg2(fileNames[1]);
		return bookDao.modifyBook(book);		
	}

	@Override
	public int deleteBook(int bnum) {
		return bookDao.deleteBook(bnum);
	}
}
