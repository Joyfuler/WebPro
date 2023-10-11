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

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부파일 저장 -> 패러미터 받아 db수정 (단, 현 비밀번호에 따라 수정할수도 있고, 안할수도 있음.)
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
				String dbmpw = mRequest.getParameter("dbmpw");
				String dbmphoto = mRequest.getParameter("dbmphoto");
				// 혹은 직접 패러미터를 받지 않았다면 세션에 있는 데이터를 가져올수도 있음.
//				HttpSession session = request.getSession();
//				String dbmpw = null;
//				String dbmphoto = null;
//				MemberDto sessionMember = (MemberDto) session.getAttribute("member");
//				if (sessionMember!=null) {
//				dbmpw = sessionMember.getMpw();
//				dbmphoto = sessionMember.getMphoto();
//				}
				String mid = mRequest.getParameter("mid");
				String oldmpw = mRequest.getParameter("oldmpw");
				if (!oldmpw.equals(dbmpw)){
					// 사용자가 수정시 입력한 현재 비밀번호와 로그인시 세션 -> hidden패러미터로 넘어온 db의 비밀번호가 동일한지 확인
					request.setAttribute("modifyErrorMsg", "현재 비밀번호를 확인");
					return; //함수 수행을 종료.
				}
				String mpw = mRequest.getParameter("mpw");
				if (mpw.equals("")) { //사용자가 바꿀 비밀번호를 입력하지 않았다면, 현재 비밀번호와 동일하게 설정
					mpw = dbmpw;
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
		