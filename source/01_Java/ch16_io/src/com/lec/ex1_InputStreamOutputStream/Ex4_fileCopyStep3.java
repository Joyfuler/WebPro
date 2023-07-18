package com.lec.ex1_InputStreamOutputStream;
 // ���帹�̾�! ���� �̸��� ��ü�� ����� �ش� �뷮��ŭ �ٷ� input�� �� �ֵ��� ��.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// ���� copy
public class Ex4_fileCopyStep3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // ������ ���� �и�����. ���� ���� ī���ϰ� �� ���� �ð��� ����� ��.
		InputStream is = null;
		OutputStream os = null;
		// ������ ��ü�� �����, �ش� ������ �뷮��ŭ �� ���� �о���̵��� �ϴ� ����.
		File originalFile = new File("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_7.mp4");
		try {
			is = new FileInputStream(originalFile); // ������ �������� ��� ���, ��ü�� ��� �־���.
			os = new FileOutputStream("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_copy.mp4");
			int cnt = 0;
			byte[] bs = new byte[(int)originalFile.length()]; // bts_7�� �뷮��ŭ �� ���� �ҷ�����.
			while (true) {
				int readByteCount = is.read(bs); // is.read() �ȿ� bs�� �־� �� ���� 1024����Ʈ�� �а� ����.
				if (readByteCount == (-1))
					break; // ���� ���� ��� ����Ǹ� ����.
				os.write(bs, 0, readByteCount); // bs�� ī��Ʈ�ϴµ� ó������ readyByteCount���� ����. (���� �κ��� �о������ x)
				cnt++; // ��� ī��Ʈ�ߴ����� �����.
			}
			System.out.println(cnt + "�� while���� �����Ͽ� ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close(); // �Ϲ������� ���߿� ������ ���� ���� �ݾ������.
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("�ɸ� �ð� = " + (end - start) / (1000.0) + "�� �ɸ�");
	}
}
