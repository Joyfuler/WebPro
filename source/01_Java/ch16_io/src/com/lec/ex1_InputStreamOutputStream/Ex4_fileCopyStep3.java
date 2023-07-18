package com.lec.ex1_InputStreamOutputStream;
 // 가장많이씀! 파일 이름을 객체로 만들어 해당 용량만큼 바로 input할 수 있도록 함.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 파일 copy
public class Ex4_fileCopyStep3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 시작할 때의 밀리세컨. 이후 파일 카피하고 난 후의 시간을 계싼할 것.
		InputStream is = null;
		OutputStream os = null;
		// 파일의 객체를 만들고, 해당 파일의 용량만큼 한 번에 읽어들이도록 하는 과정.
		File originalFile = new File("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_7.mp4");
		try {
			is = new FileInputStream(originalFile); // 파일의 직접적인 경로 대신, 객체를 대신 넣어줌.
			os = new FileOutputStream("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_copy.mp4");
			int cnt = 0;
			byte[] bs = new byte[(int)originalFile.length()]; // bts_7의 용량만큼 한 번에 불러들임.
			while (true) {
				int readByteCount = is.read(bs); // is.read() 안에 bs를 넣어 한 번에 1024바이트씩 읽게 만듬.
				if (readByteCount == (-1))
					break; // 읽은 것이 모두 종료되면 멈춤.
				os.write(bs, 0, readByteCount); // bs를 카운트하는데 처음부터 readyByteCount까지 읽음. (없는 부분은 읽어들이지 x)
				cnt++; // 몇번 카운트했는지를 계싼함.
			}
			System.out.println(cnt + "번 while문을 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // 일반적으론 나중에 설정한 것을 먼저 닫아줘야함.
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 = " + (end - start) / (1000.0) + "초 걸림");
	}
}
