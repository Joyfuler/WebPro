package com.lec.ex3_bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//bufferedStream을 이용해 한번에 불러옴. 
// 1. 기본스트림(Filereader) + 보조스트림(bufferedReader) 객체 생성 (파일을 연다)
// 2. 데이터를 읽는다. (bufferedReader를 통해 한줄씩 읽음)
// 3. 스트림을 닫는다. ( 닫을 떄는 열 때와 반대 순서로. 나중에 연 것을 먼저 닫는다.)
public class Ex01 {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("D:/WebPro/source/01_Java/ch16_io/txtFile/InTest.txt"); // 기본 스트림 생성.
			br = new BufferedReader(reader); // 보조 스트림(2중빨대) 앞서서 파일 불러온 것을 다시 한번 꼽는다.
			while (true) {
				String linedata = br.readLine(); // 2바이트씩 읽는 것이 아니라, 줄을 바꿀 때까지 읽도록 하는 명령어. 2바이트보다 더 빠르고 가성비가 조음
				if (linedata == null)
					break; // reader형 파일의 끝은 -1이 아닌 null. 반복문 속에서 linedata가 계속 반복
				System.out.println(linedata);
			}
			System.out.println("========파일 입력 끝========");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)	br.close();
				if (reader != null) reader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		} // main

	} //class

