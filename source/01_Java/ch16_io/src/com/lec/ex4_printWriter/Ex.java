package com.lec.ex4_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

// printWriter : OutputStream을 기본 스트림으로 보조하는 보조스트림. or Writer를 기본 스트림으로 하는 보조스트림으로 사용할 수도 있음.
// printWriter : 혹은 혼자 기본스트림처럼 사용도 가능.
// BufferedReader : Reader를 기본스트림으로 하는 보조스트림.(reader 생성 후 bufferedreader 만들어야...)
public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter pw = null;
		try {
			// 1번경로. outputStream을 기본스트림, printWriter가 보조스트림
//			os = new FileOutputStream("txtFile/outTest.txt",true);
//			pw = new PrintWriter(os);
			// 2번경로. writer를 기본스트림, printWriter가 보조스트림.
//			writer = new FileWriter("txtFile/outTest.txt",true);
//			pw = new PrintWriter(writer);
			// 3번경로. PrintWriter를 기본스트림처럼 사용.
			pw = new PrintWriter("txtFile/outTest.txt"); // 단, 이 경우 어펜드가 불가능함.
			
			System.out.println("안녕하세요\n반갑습니다");
			pw.println("안녕하세요\n반갑습니다");
			// sout과 printwriter를 동일하게 사용가능.
			System.out.print("print는 자동개행이 안되요. 그래서 개행이 필요하면 추가를 해줘야 해요\n");
			pw.print("print는 자동개행이 안되요. 그래서 개행이 필요하면 추가를 해줘야 해요\n");
			System.out.printf("%s %3d %3d %5.1f\n", "홍길동", 100, 100, 100.0);
			pw.printf("%s %3d %3d %5.1f\n", "홍길동", 100, 100, 100.0);
			System.out.printf("%s %3d %3d %5.1f\n", "신길동", 90, 91, 90.5);
			pw.printf("%s %3d %3d %5.1f\n", "신길동", 90, 91, 90.5);
			System.out.printf("%s %3d %3d %5.1f\n", "박길동", 95, 97, 96.0);
			pw.printf("%s %3d %3d %5.1f\n", "박길동", 95, 97, 96.0);
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pw != null)
					pw.close();
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
