package com.lec.ex3_bufferedReader;
// 사용자로부터 파일 이름을 입력받음 (bufferedReader로도 읽을 수 있으나, scanner로 진행함.) -> 해당 파일을 console에 출력.

// 해당 파일 이름이 존재하는지 check하고, 만일 입력한 파일이 존재하지 않는 경우는 경고문구?

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Ex02_filenameConsolePrint {
	public static void main(String[] args) {

		Reader reader = null;
		BufferedReader br = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("읽어올 파일 명은? : "); // abc.txt 라고 입력한다는 가정 하에...txtFile/abc.txt
		String fileName = scanner.next(); // 파일이름을 입력받았음.
		File file = new File("txtFile/" + fileName); // 우선 file 객체를 만들고 사용자가 입력한 파일네임을 넣어줌
		scanner.close();
		if (file.exists()) { // 해당 파일이 존재하면 true, 없으면 false를 반환함.
			System.out.println("해당 파일이 존재합니다.");
			try {
				reader = new FileReader(file); // 기본스트림생성한 것.
				br = new BufferedReader(reader); // 보조스트림 생성 (기본스트림경유)
				while (true) { // 보조스트림을 통해 1줄씩 read
					String linedata = br.readLine(); // 파일 권한이 부족하거나 없거나 등등...
					if (linedata == null)
						break; // null일때 break; 잊지말길
					System.out.println(linedata);

				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (br != null)
						br.close();
					if (reader != null)
						reader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			System.out.println("입력하신 파일은 존재하지 않습니다.");
		}
	}
}
