package com.lec.ch12.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUpService {
	private static final Logger logger = LoggerFactory.getLogger(FileUpService.class);
	public boolean fileUp(MultipartHttpServletRequest mRequest, ModelAndView mav) {		
		boolean isUpload = false;
		// 파일을 첨부하지 않은 경우는 빈 스트링으로 들어온다.
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:\\webPro\\source\\09_Spring\\ch12_fileUpLoad\\src\\main\\webapp\\upload\\";
		String[] fileNames = new String[3]; // {null, null, null}. jsp에서 파일이 3개까지 업로드가능
		int i = 0;
		Iterator<String> params = mRequest.getFileNames(); // file1 / file2 / file3 3가지를 params가 참조
		while (params.hasNext()) {
			String param = params.next(); // 다음 params. 처음에는 file1
			logger.info(i + "번쨰 파라미터 이름: " + param);
			MultipartFile mFile = mRequest.getFile(param);
			fileNames[i] = mFile.getOriginalFilename();
			logger.info(
					fileNames[i] == null ? "파일없음" : fileNames[i].equals("") ? "첨부안함" : "첨부 파일 이름은" + fileNames[i]);
			// 만일 첨부한 이미지가 이미 서버에 있다면, 덮어씌워선 안 됨
			if (fileNames[i] != null && !fileNames[i].equals("")) {
				// 첨부했다면 서버에 동일한 파일이 있는지를 확인
				if (new File(uploadPath + fileNames[i]).exists()) {
					// true라면 이미 서버에 동일한 이름의 파일이 존재한 것. 파일 이름 변경 필요
					// 현재 시간을 대입해 넣을 수 있음.
					fileNames[i] = System.currentTimeMillis() + "_" + fileNames[i];
				}
				try {
					mFile.transferTo(new File(uploadPath + fileNames[i]));
					// 서버에 파일을 저장. (파일 이름이 아닌 파일 객체로 해야 하므로 new File 대입)
					logger.info("서버에 저장된 파일 : " + uploadPath + fileNames[i]);
					logger.info("복사될 파일 :" + backupPath + fileNames[i]);
					isUpload = filecopy(uploadPath + fileNames[i], backupPath + fileNames[i]);
					// 서버에 저장되었다면 소스폴더에 파일복사 메소드를 실행. 첫번째 매개변수는 복사할 파일 / 두번쨰 매개변수는 복사될 위치
				} catch (IllegalStateException e) {
					logger.error(e.getMessage());
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			} else {
				// 첨부를 안 했다면 서버로 파일 카피를 수행하지 않음.
			}
			i++;
		}
		mav.addObject("fileNames", fileNames);
		return isUpload;
	}

	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
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
				isCopy = true;
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
}
