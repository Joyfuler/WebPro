package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// ���� copy
public class Ex4_fileCopyStep1 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // ������ ���� �и�����. ���� ���� ī���ϰ� �� ���� �ð��� ����� ��.
		InputStream is = null; 
		OutputStream os = null;
		try {
			is = new FileInputStream("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_7.mp4");
			os = new FileOutputStream("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_copy.mp4");
			int cnt = 0;
			while (true) {
				int i = is.read(); // 1����Ʈ ����
				if (i == (-1)) break; // ���� ���� ��� ����Ǹ� ����.
				os.write(i); // ���� i���� �״�� ��. ����������. (�� 7�ް��̹Ƿ� �� 740�������� �а� ���� �ݺ���.)
				cnt++; // ��� ī��Ʈ�ߴ����� �����.
				if (cnt % 100000 == 0){
					System.out.println(cnt +"/7,460,545 " + (int)(cnt/7460545.0 * 100) + "�ۼ�Ʈ �����");
				}
			}
			System.out.println(cnt + "�� while���� �����Ͽ� ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());			
		} finally {
			try {
				if (os != null)	os.close(); // �Ϲ������� ���߿� ������ ���� ���� �ݾ������.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (is != null) is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		long end = System.currentTimeMillis();
		System.out.println("�ɸ� �ð� = " + (end-start) / (1000.0) + "�� �ɸ�");
	}
}
