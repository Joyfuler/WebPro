package com.lec.ex2_ReaderWriter;
// 파일을 연다 (스트림 객체 생성) --> 데이터를 2바이트씩 읽음. (read() 메소드 사용. -1이 나올 때까지) --> 파일 닫기

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_FileReader {
	public static void main(String[] args) {

		Reader reader = null;
		try { // 1. 파일의 경로를 연다.
			reader = new FileReader("txtFile/Intest");

			// 2. 데이터를 읽는다
			while (true) {
				int i = reader.read(); // 읽는 것은 2바이트씩, int는 4바이트. (byte는 1바이트이므로 x)
				if (i == -1)
					break;
				System.out.print((char) i + "(" + i + ")");
			}
			System.out.println("\n읽기 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} // reader 아래에 filereader 존재함.
		catch (IOException e) {

			System.out.println(e.getMessage());
		} finally {
			try { // 3단계, 파일 닫기. reader는 꼭 닫기 전에 null이 아닌지를 먼저 확인할 것. null상태에선 닫히지 않아서 오류가남
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}
}
