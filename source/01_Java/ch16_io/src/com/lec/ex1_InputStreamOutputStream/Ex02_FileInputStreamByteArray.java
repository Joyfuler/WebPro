package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. 파일열기   2. 데이터 읽기(read(byte[])) 3. 닫기
public class Ex02_FileInputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		// is = new FileInputStream("txtFile/Intest"); 상대경로 - 내 프로젝트 안에 있는 파일을 불러오는 절차.

		try { // 1. 파일 열기
			is = new FileInputStream("D:\\WebPro\\source\\01_Java\\ch16_io\\txtFile\\InTest");
			// 2. 파일 읽기
			byte[] bs = new byte[10];
			while (true) {
				int readByteCount = is.read(bs); // bs 배열인 10개만큼 읽고, 읽은 byte 수를 리턴함. 다 읽으면 read값은 -1이 됨.
				if (readByteCount == -1) break;
				for (int i = 0; i < readByteCount; i++) { // bs.length인 경우는 바이트 상관없이 무조건 끝까지 출력하므로,
														  // readByteCount만큼만 읽어서 글자가 있는 곳까지만 출력하게 수정하였음.
					// System.out.printf("%3d/" , bs[i]); // 출력 후 슬래시, 3자리로 출력하였음. (아스키코드는 3자리까지 있으므로)
					System.out.printf("%s/" , (char)bs[i]);
				}
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음" + e.getMessage());
		} // 절대경로. 역슬래시(\) 뒤의 명령어를 읽으려 하는 경향이 있으므로,
			// 역슬래시를 2개 사용하거나 슬래시로 바꿔줌.
		catch (IOException e) {
			System.out.println("읽기 권한이 없거나, 닫히지 않은 파일의 경우 예외 메시지 : " + e.getMessage());			
		}

		// finally를 우선 만들고, null이 아닐 때 꼭 닫는 과정을 넣어주자.
		finally {
			try {
				if (is != null)
					is.close(); // 파일을 write하는 경우, 닫혀있지 않으면 저장되지 않을 수도 있음.
			} catch (IOException e) {
			}
		}
	}
	// 2. 데이터 읽기

}
