package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 빨대?! 1) 스트림 생성(파일열기..) 2) 데이터 읽기 (read 메소드 사용) 3) 파일을 닫는다. (다 읽었다면 빨대빼기작업..close 메소드 사용)
public class Ex01_FileInputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try { // 파일을 불렀는데 만약 파일 이름을 잘못 쳐서 에러가 난다면? --> 예외가 기본적으로 발생하므로 try-catch를 꼭 넣어줘야함.
			is = new FileInputStream("txtFile/inTest.txt");
			// 2. 데이터를 읽는다 (파일 끝까지 반복적으로 읽는다)
			while (true) {
				int i = is.read(); // 1바이트 읽음. read가 int를 받기 때문.
				if (i == -1)
					break; // 읽는 위치가 끝나면 -1이 됨.

				System.out.print((char) i + "(" + i + ")");
			}
			
			
			
			System.out.println("\n ===== 끝 =====");
		} catch (IOException e) {
			// 파일은 존재하지만, 읽을 수 있는 권한이 없거나, 닫혀서 읽을 수 없는 오류인 경우.
			System.out.println("예외 메시지 (파일 권한이 없거나 닫혀있음." + e.getMessage());
			// 중간에 catch에 걸릴 수 있으므로, finally에 파일을 닫는 절차를 넣는다.
		}
		 finally { // 예외가 발생하지 않은 경우, while이 끝나면 filnally로 이동함.
			try {
				if (is != null) { // 만일 파일 경로가 잘못되어 is가 null이 될 경우는 close가 안 되기 때문.
					is.close();

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
