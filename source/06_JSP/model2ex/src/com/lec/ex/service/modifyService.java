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

public class modifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024 * 1024 * 5;
		String mphoto = "";
		int result = MemberDao.FAIL;		
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			while (params.hasMoreElements()) {
				String param = params.nextElement(); // params가 한개이므로 String. 여러개라면 String[] 사용
				mphoto = mRequest.getFilesystemName(param); //첨부한 파일명
			}				
				String dbmphoto = mRequest.getParameter("dbMphoto");				
				String mid = mRequest.getParameter("mid");
				String oldmpw = mRequest.getParameter("oldMpw");				
				String mpw = mRequest.getParameter("mpw");
				if (mpw.equals("")) { //사용자가 바꿀 비밀번호를 입력하지 않았다면, 현재 비밀번호와 동일하게 설정
					mpw = oldmpw;
				}
				String mname = mRequest.getParameter("mname");
				String memail = mRequest.getParameter("memail");
				//정보 수정시 사진을 첨부하지 않은 경우, 기존 이미지(dbmphoto)가 사진이미지로 
				mphoto = mphoto ==null? dbmphoto: mphoto;
				String mbirthStr = mRequest.getParameter("mbirth");
				Date mbirth = null;
				if (!mbirthStr.equals("")) {
					mbirth = Date.valueOf(mbirthStr);
				}
				String maddress = mRequest.getParameter("maddress");
				MemberDao mDao = MemberDao.getInstance();
				MemberDto mDto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
				result = mDao.modifyMember(mDto);
				if (result == MemberDao.SUCCESS) {
					HttpSession session = request.getSession();
					session.setAttribute("member", mDto);
					request.setAttribute("modifyResult", "회원정보수정완료");
				} else {
					request.setAttribute("modifyErrorMsg", "회원정보수정 실패");
				}			
		} catch (IOException e) {		
			System.out.println(e.getMessage());
		} 
		//서버에 저장된 파일을 소스폴더로 복사. (파일명 noimg.jpg 아니거나 result == SUCCESS인 경우)
		File serverFile = new File(path + "/" + mphoto);
		if (serverFile.exists() && !mphoto.equals("NOIMG.JPG") && result == MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile); // 서버에 업로드된 파일
				os = new FileOutputStream("D:\\webPro\\source\\06_JSP\\model2ex\\WebContent\\memberPhotoUp\\" + mphoto); 
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