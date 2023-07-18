package com.lec.ex2_ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// 마찬가지. 파일 연다 -> 출력한다 -> 닫는다.
// try 절에서는 string 절... finally에서 close();
public class Ex02_FileWriter {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			
			 writer = new FileWriter("txtFile/outTest.txt",true); 
			 /*char[] msg =
			 * {'안','녕','!',' ','H','e','l','l','o','\n'}; for (char m : msg) {
			 * writer.write(m); // 배열의 값 m을 outTest.txt 에다가 저장하엿음 }
			 */
			String msg = "안녕! Hi\n장마철 건강 조심하세요. \n";
			writer.write(msg); // 배열 만들지않아도 됨. 그냥 writer(객체) 하면 그만임
			// 단, arraylist 객체인 경우라면 배열을 for문을 통해서 출력해야 함.
			msg = "다음 주까지 비온대요. 모두 모두 뽀송뽀송\n";
			writer.write(msg);
			System.out.println("파일 출력 완료");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (writer != null)
				try {
					writer.close(); // 닫는 작업. null이 아닐떄만이라는 조건을 넣는 것을 잊지 말것 !
				} catch (IOException e) {
					e.getMessage();
				}
		}
	}
}
