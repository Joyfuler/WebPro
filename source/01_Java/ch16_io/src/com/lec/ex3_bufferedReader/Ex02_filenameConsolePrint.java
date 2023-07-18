package com.lec.ex3_bufferedReader;
// ����ڷκ��� ���� �̸��� �Է¹��� (bufferedReader�ε� ���� �� ������, scanner�� ������.) -> �ش� ������ console�� ���.

// �ش� ���� �̸��� �����ϴ��� check�ϰ�, ���� �Է��� ������ �������� �ʴ� ���� �����?

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
		System.out.print("�о�� ���� ����? : "); // abc.txt ��� �Է��Ѵٴ� ���� �Ͽ�...txtFile/abc.txt
		String fileName = scanner.next(); // �����̸��� �Է¹޾���.
		File file = new File("txtFile/" + fileName); // �켱 file ��ü�� ����� ����ڰ� �Է��� ���ϳ����� �־���
		scanner.close();
		if (file.exists()) { // �ش� ������ �����ϸ� true, ������ false�� ��ȯ��.
			System.out.println("�ش� ������ �����մϴ�.");
			try {
				reader = new FileReader(file); // �⺻��Ʈ�������� ��.
				br = new BufferedReader(reader); // ������Ʈ�� ���� (�⺻��Ʈ������)
				while (true) { // ������Ʈ���� ���� 1�پ� read
					String linedata = br.readLine(); // ���� ������ �����ϰų� ���ų� ���...
					if (linedata == null)
						break; // null�϶� break; ��������
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
			System.out.println("�Է��Ͻ� ������ �������� �ʽ��ϴ�.");
		}
	}
}
