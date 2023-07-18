package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
// ������ ���� (��Ʈ�� ��ü ����) -> ���� -> ������ �ݴ´�.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_FileOutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); //�⺻���� �ڿ� ,false�� ��. �� �� ,true�� ������ append�� �Ǿ� ������ �߰��� �� ����.
		//	byte[] bs = { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'j', 'a', 'v', 'a', '\n'};
			String msg = "Hi, Java\n012345678\n�ȳ�"; // ������ ���� ��Ʈ�� ������ �Է��� ��, getbytes �޼ҵ带 �̿��Ͽ� �ɰ��Ⱑ ������.
			byte[] bs = msg.getBytes();
		//	for (byte b : bs) {
				// os.write(b); // ���� ���� read()��, �� ���� write() �� �����.
			os.write(bs);
			System.out.println("���� ��� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println("������ ���ٰ� �ϳ׿�" + e.getMessage());
		} // �ش� ������ ������ ������ �������� ����. �� ��� ���� x, ���� �ؽ�Ʈ ������ �������. �̹� �ִ� ������ ���, ���.
		catch (IOException e) {
			

		} finally {
			try {
				if (os != null)
					os.close(); // �� os�� �ƴ� �� �ݱ⸦ �� �ֱ�.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // close
		} // try - catch - finally
	} //main
} //class
