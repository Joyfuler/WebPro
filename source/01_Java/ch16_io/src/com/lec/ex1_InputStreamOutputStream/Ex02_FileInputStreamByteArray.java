package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. ���Ͽ���   2. ������ �б�(read(byte[])) 3. �ݱ�
public class Ex02_FileInputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		// is = new FileInputStream("txtFile/Intest"); ����� - �� ������Ʈ �ȿ� �ִ� ������ �ҷ����� ����.

		try { // 1. ���� ����
			is = new FileInputStream("D:\\WebPro\\source\\01_Java\\ch16_io\\txtFile\\InTest");
			// 2. ���� �б�
			byte[] bs = new byte[10];
			while (true) {
				int readByteCount = is.read(bs); // bs �迭�� 10����ŭ �а�, ���� byte ���� ������. �� ������ read���� -1�� ��.
				if (readByteCount == -1) break;
				for (int i = 0; i < readByteCount; i++) { // bs.length�� ���� ����Ʈ ������� ������ ������ ����ϹǷ�,
														  // readByteCount��ŭ�� �о ���ڰ� �ִ� �������� ����ϰ� �����Ͽ���.
					// System.out.printf("%3d/" , bs[i]); // ��� �� ������, 3�ڸ��� ����Ͽ���. (�ƽ�Ű�ڵ�� 3�ڸ����� �����Ƿ�)
					System.out.printf("%s/" , (char)bs[i]);
				}
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã��" + e.getMessage());
		} // ������. ��������(\) ���� ��ɾ ������ �ϴ� ������ �����Ƿ�,
			// �������ø� 2�� ����ϰų� �����÷� �ٲ���.
		catch (IOException e) {
			System.out.println("�б� ������ ���ų�, ������ ���� ������ ��� ���� �޽��� : " + e.getMessage());			
		}

		// finally�� �켱 �����, null�� �ƴ� �� �� �ݴ� ������ �־�����.
		finally {
			try {
				if (is != null)
					is.close(); // ������ write�ϴ� ���, �������� ������ ������� ���� ���� ����.
			} catch (IOException e) {
			}
		}
	}
	// 2. ������ �б�

}
