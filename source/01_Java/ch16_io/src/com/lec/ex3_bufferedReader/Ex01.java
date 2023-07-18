package com.lec.ex3_bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//bufferedStream�� �̿��� �ѹ��� �ҷ���. 
// 1. �⺻��Ʈ��(Filereader) + ������Ʈ��(bufferedReader) ��ü ���� (������ ����)
// 2. �����͸� �д´�. (bufferedReader�� ���� ���پ� ����)
// 3. ��Ʈ���� �ݴ´�. ( ���� ���� �� ���� �ݴ� ������. ���߿� �� ���� ���� �ݴ´�.)
public class Ex01 {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("D:/WebPro/source/01_Java/ch16_io/txtFile/InTest.txt"); // �⺻ ��Ʈ�� ����.
			br = new BufferedReader(reader); // ���� ��Ʈ��(2�߻���) �ռ��� ���� �ҷ��� ���� �ٽ� �ѹ� �Ŵ´�.
			while (true) {
				String linedata = br.readLine(); // 2����Ʈ�� �д� ���� �ƴ϶�, ���� �ٲ� ������ �е��� �ϴ� ��ɾ�. 2����Ʈ���� �� ������ ������ ����
				if (linedata == null)
					break; // reader�� ������ ���� -1�� �ƴ� null. �ݺ��� �ӿ��� linedata�� ��� �ݺ�
				System.out.println(linedata);
			}
			System.out.println("========���� �Է� ��========");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)	br.close();
				if (reader != null) reader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		} // main

	} //class

