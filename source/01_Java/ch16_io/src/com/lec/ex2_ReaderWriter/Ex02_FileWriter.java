package com.lec.ex2_ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// ��������. ���� ���� -> ����Ѵ� -> �ݴ´�.
// try �������� string ��... finally���� close();
public class Ex02_FileWriter {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			
			 writer = new FileWriter("txtFile/outTest.txt",true); 
			 /*char[] msg =
			 * {'��','��','!',' ','H','e','l','l','o','\n'}; for (char m : msg) {
			 * writer.write(m); // �迭�� �� m�� outTest.txt ���ٰ� �����Ͽ��� }
			 */
			String msg = "�ȳ�! Hi\n�帶ö �ǰ� �����ϼ���. \n";
			writer.write(msg); // �迭 �������ʾƵ� ��. �׳� writer(��ü) �ϸ� �׸���
			// ��, arraylist ��ü�� ����� �迭�� for���� ���ؼ� ����ؾ� ��.
			msg = "���� �ֱ��� ��´��. ��� ��� �ǼۻǼ�\n";
			writer.write(msg);
			System.out.println("���� ��� �Ϸ�");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (writer != null)
				try {
					writer.close(); // �ݴ� �۾�. null�� �ƴҋ����̶�� ������ �ִ� ���� ���� ���� !
				} catch (IOException e) {
					e.getMessage();
				}
		}
	}
}
