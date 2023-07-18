package com.lec.ex4_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

// printWriter : OutputStream�� �⺻ ��Ʈ������ �����ϴ� ������Ʈ��. or Writer�� �⺻ ��Ʈ������ �ϴ� ������Ʈ������ ����� ���� ����.
// printWriter : Ȥ�� ȥ�� �⺻��Ʈ��ó�� ��뵵 ����.
// BufferedReader : Reader�� �⺻��Ʈ������ �ϴ� ������Ʈ��.(reader ���� �� bufferedreader ������...)
public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter pw = null;
		try {
			// 1�����. outputStream�� �⺻��Ʈ��, printWriter�� ������Ʈ��
//			os = new FileOutputStream("txtFile/outTest.txt",true);
//			pw = new PrintWriter(os);
			// 2�����. writer�� �⺻��Ʈ��, printWriter�� ������Ʈ��.
//			writer = new FileWriter("txtFile/outTest.txt",true);
//			pw = new PrintWriter(writer);
			// 3�����. PrintWriter�� �⺻��Ʈ��ó�� ���.
			pw = new PrintWriter("txtFile/outTest.txt"); // ��, �� ��� ����尡 �Ұ�����.
			
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			pw.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			// sout�� printwriter�� �����ϰ� ��밡��.
			System.out.print("print�� �ڵ������� �ȵǿ�. �׷��� ������ �ʿ��ϸ� �߰��� ����� �ؿ�\n");
			pw.print("print�� �ڵ������� �ȵǿ�. �׷��� ������ �ʿ��ϸ� �߰��� ����� �ؿ�\n");
			System.out.printf("%s %3d %3d %5.1f\n", "ȫ�浿", 100, 100, 100.0);
			pw.printf("%s %3d %3d %5.1f\n", "ȫ�浿", 100, 100, 100.0);
			System.out.printf("%s %3d %3d %5.1f\n", "�ű浿", 90, 91, 90.5);
			pw.printf("%s %3d %3d %5.1f\n", "�ű浿", 90, 91, 90.5);
			System.out.printf("%s %3d %3d %5.1f\n", "�ڱ浿", 95, 97, 96.0);
			pw.printf("%s %3d %3d %5.1f\n", "�ڱ浿", 95, 97, 96.0);
		
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
