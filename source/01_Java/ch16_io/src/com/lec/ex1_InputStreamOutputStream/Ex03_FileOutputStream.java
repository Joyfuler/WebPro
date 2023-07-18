package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
// 파일을 연다 (스트림 객체 생성) -> 쓴다 -> 파일을 닫는다.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_FileOutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); //기본값은 뒤에 ,false가 들어감. 이 때 ,true를 넣으면 append가 되어 내용을 추가할 수 있음.
		//	byte[] bs = { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'j', 'a', 'v', 'a', '\n'};
			String msg = "Hi, Java\n012345678\n안녕"; // 다음과 같이 스트링 변수를 입력한 후, getbytes 메소드를 이용하여 쪼개기가 가능함.
			byte[] bs = msg.getBytes();
		//	for (byte b : bs) {
				// os.write(b); // 읽을 떄는 read()를, 쓸 떄는 write() 를 사용함.
			os.write(bs);
			System.out.println("파일 출력 완료");
		} catch (FileNotFoundException e) {
			System.out.println("폴더가 없다고 하네용" + e.getMessage());
		} // 해당 폴더는 있지만 파일은 존재하지 않음. 이 경우 에러 x, 새로 텍스트 파일을 만들어줌. 이미 있는 파일인 경우, 덮어씀.
		catch (IOException e) {
			

		} finally {
			try {
				if (os != null)
					os.close(); // 꼭 os가 아닐 때 닫기를 해 주기.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // close
		} // try - catch - finally
	} //main
} //class
