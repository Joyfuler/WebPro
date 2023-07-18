package com.lec.ex2_ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// 파일 이름과 출력할 내용을 입력받아 해당 파일을 생성
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Writer writer = null;
		System.out.println("저장할 파일 이름은?");
		String fileName = scanner.next(); // 파일이름은 정확해야하므로 nextline 대신 next를 사용함. abc => txtFile/abc.txt
		scanner.nextLine(); // scanner.next에서 받았던 \n을 지워주는 작업.
		try {
			writer = new FileWriter("txtFile" + fileName + ".txt",true); // 사용자에게 받은 이름을 파일이름으로 사용.
			while (true) {
				System.out.print("파일 출력할 내용은? (종료를 원하면 x를 눌러주세요.");
				String msg = scanner.nextLine();
				if (msg.equalsIgnoreCase("x"))
					break;
				writer.write(msg + "\n"); // 순서대로 입력받고, 다음 값은 엔터
				System.out.println(msg);
			}
			System.out.println("txtFile/" + fileName + ".txt 파일로 출력 저장 완료");

		} catch (IOException e) { // 해당폴더가 없는 경우의 예외
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
