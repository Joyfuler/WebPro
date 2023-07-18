package com.lec.ex2_ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// ���� �̸��� ����� ������ �Է¹޾� �ش� ������ ����
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Writer writer = null;
		System.out.println("������ ���� �̸���?");
		String fileName = scanner.next(); // �����̸��� ��Ȯ�ؾ��ϹǷ� nextline ��� next�� �����. abc => txtFile/abc.txt
		scanner.nextLine(); // scanner.next���� �޾Ҵ� \n�� �����ִ� �۾�.
		try {
			writer = new FileWriter("txtFile" + fileName + ".txt",true); // ����ڿ��� ���� �̸��� �����̸����� ���.
			while (true) {
				System.out.print("���� ����� ������? (���Ḧ ���ϸ� x�� �����ּ���.");
				String msg = scanner.nextLine();
				if (msg.equalsIgnoreCase("x"))
					break;
				writer.write(msg + "\n"); // ������� �Է¹ް�, ���� ���� ����
				System.out.println(msg);
			}
			System.out.println("txtFile/" + fileName + ".txt ���Ϸ� ��� ���� �Ϸ�");

		} catch (IOException e) { // �ش������� ���� ����� ����
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
