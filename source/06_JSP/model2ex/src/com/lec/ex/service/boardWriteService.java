package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class boardWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("member");
		String mid = dto.getMid();
		String fip = request.getRemoteAddr();
//		String ftitle = request.getParameter("ftitle");
//		String fcontent = request.getParameter("fcontent");
//		String ffileName = request.getParameter("ffileName");//		
//		BoardDao bDao = BoardDao.getInstance();
//		request.setAttribute("writeResult", bDao.writeBoard();		
		String path = request.getRealPath("fileBoardUp");
		// tomcat 폴더 기준의 경로를 path에 대입.
		int maxSize = 1024 * 1024 * 5; // 최대용량 5메가
		String ffileName = ""; // 첨부된 파일의 이름
		int result = MemberDao.FAIL; // 회원가입 결과를 저장하는 변수
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames(); // 파일 첨부하는 패러미터가 몇 개인지? 여러개라면 FileNames
			while (params.hasMoreElements()) {
				String param = params.nextElement(); // 패러미터가 존재한다면, param에 해당 파일명을 가져옴.
				ffileName = mRequest.getFilesystemName(param); // 시스템상의 실제 경로를 mphoto에 넣는다.
				String ftitle = mRequest.getParameter("ftitle");
				String fcontent = mRequest.getParameter("fcontent");
				BoardDao bDao = BoardDao.getInstance();
				result = bDao.writeBoard(ftitle, fcontent, ffileName, fip, mid);				
				if (result == BoardDao.SUCCESS) { // 가입 불가능한 아이디 (중복)
					request.setAttribute("boardResult", "게시글 작성완료");				
				} else {
					request.setAttribute("boardResult", "게시글 작성실패");
					}
				}			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("boardResult", "게시글 작성실패");
		}
		File serverFile = new File(path + "/" + ffileName);
		if (serverFile.exists() && result == BoardDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile); // 서버에 업로드된 파일
				os = new FileOutputStream("D:\\webPro\\source\\06_JSP\\model2ex\\WebContent\\fileBoardUp\\"+serverFile); 
				// 소스폴더로 복사될 파일
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int readByteCnt = is.read(bs);
					if (readByteCnt == -1)
						break;
					os.write(bs, 0, readByteCnt);
				} // 복사작업. 각 데이터의 첫 바이트부터 끝까지
				System.out.println(ffileName + " 복사 완료");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}	
		}
	}
}	
		