package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// ���� copy
public class Ex4_fileCopyStep2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // ������ ���� �и�����. ���� ���� ī���ϰ� �� ���� �ð��� ����� ��.
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_7.mp4");
			os = new FileOutputStream("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_copy.mp4");
			int cnt = 0;
			byte[] bs = new byte[1024]; // 1�ް��� �а���.
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("�ɸ� �ð� = " + (end - start) / (1000.0) + "�� �ɸ�");
	}
}
