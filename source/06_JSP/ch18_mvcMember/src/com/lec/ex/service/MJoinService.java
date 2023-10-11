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

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부한 파일 저장 -> 패러미터를 받아 DB에 저장 -> 첨부한 파일을 소스폴더로 복사
		String path = request.getRealPath("memberPhotoUp");
		// tomcat 폴더 기준의 경로를 path에 대입.
		int maxSize = 1024 * 1024 * 5; // 최대용량 5메가
		String mphoto = ""; // 첨부된 파일의 이름
		int result = MemberDao.FAIL; // 회원가입 결과를 저장하는 변수
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames(); // 파일 첨부하는 패러미터가 몇 개인지? 여러개라면 FileNames
			while (params.hasMoreElements()) {
				String param = params.nextElement(); // 패러미터가 존재한다면, param에 해당 파일명을 가져옴.
				mphoto = mRequest.getFilesystemName(param); // 시스템상의 실제 경로를 mphoto에 넣는다.
				String mid = mRequest.getParameter("mid");
				String mpw = mRequest.getParameter("mpw");
				String mname = mRequest.getParameter("mname");
				String memail = mRequest.getParameter("memail");
				mphoto = (mphoto == null ? "NOIMG.JPG" : mphoto);
				// 첨부한 사진이 없다면 noimg.jpg로 대체됨
				String mbirthStr = mRequest.getParameter("mbirth");
				Date mBirth = null;
				if (!mbirthStr.equals("")) {
					mBirth = Date.valueOf(mbirthStr);
				}
				String maddress = mRequest.getParameter("maddress");
				// 모든 패러미터를 받았다면 회원가입 단계를 수행. 단, 반드시 중복체크가 선행되어야 함.
				MemberDao mDao = MemberDao.getInstance();
				result = mDao.midConfirm(mid); // 중복여부 체크
				if (result == MemberDao.EXISTENT) { // 가입 불가능한 아이디 (중복)
					request.setAttribute("joinErrorMsg", "중복된 ID");
				} else if (result == MemberDao.NONEXISTENT) {
					MemberDto newMember = new MemberDto(mid, mpw, mname, memail, mphoto, mBirth, maddress, null);
					result = mDao.joinMember(newMember);
					if (result == MemberDao.SUCCESS) {
						HttpSession session = request.getSession();
						session.setAttribute("mid", mid);
						request.setAttribute("joinResult", "회원가입이 완료되었습니다");
					} else {
						request.setAttribute("joinErrorMsg", "회원가입 정보가 길어 회원가입이 실패함");
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("joinErrorMsg", "첨부파일의 용량 제한은 5MB 이하입니다");
		}
		// 모든 작업이 완료되었다면 서버에 업로드된 파일을 소스 폴더로 복사함.
		File serverFile = new File(path + "/" + mphoto);
		if (serverFile.exists() && !mphoto.equals("NOIMG.JPG") && result == MemberDao.SUCCESS) {
			// 파일첨부를 했을 경우와 안 했을 경우를 나눔. (혹은 용량이 커서 안 들어와 회원가입이 안 되었을 때 등)
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile); // 서버에 업로드된 파일
				os = new FileOutputStream("D:/webPro/source/06_JSP/ch18_mvcMember/WebContent/memberPhotoUp/" + mphoto); 
				// 소스폴더로 복사될 파일
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int readByteCnt = is.read(bs);
					if (readByteCnt == -1)
						break;
					os.write(bs, 0, readByteCnt);
				} // 복사작업. 각 데이터의 첫 바이트부터 끝까지
				System.out.println(mphoto + " 복사 완료");
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