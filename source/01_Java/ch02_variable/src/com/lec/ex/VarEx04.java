package com.lec.ex;

import javax.swing.text.GapContent;

public class VarEx04 {
	public static void main(String[] args) {
		int i = 40; // 4����Ʈ
		long l = 2200000000L; // ���� �⺻������ int�̹Ƿ� long�� �����ص� ���� ����. �ڿ� L�� �ٿ����..
		System.out.println("l = " + l);
		boolean b = true; // 1����Ʈ
		System.out.println("b = " + b); // true Ȥ�� false��
		
		// �Ǽ��� double�� �⺻. float��...? 
		float f = 3.1415926539F; // float�� 4����Ʈ�̹Ƿ� ���� ����. 
		System.out.println("f = " + f);
		double d = 3.1415926539; // 8����Ʈ
		System.out.println("d = " + d);
		
		if (f == d) { // if else ����. if (a) { } else { }
		System.out.println("f�� d�� ����");
		}	else {
			System.out.println("f�� d�� �ٸ���");
						
		}
		 f = 10.1f;
		 d = 10.1;
		 
		 System.out.println("f = " + f);
		 System.out.println("d = " + d);
		 if (f == d) {
			 System.out.println("f�� d�� ����");
		 } else {
			System.out.println("f�� d�� �ٸ���"); // ���� ������ �ٸ� ������ �Ǵܵ�.
		}
		 double result = d + 1; // 8byte + 4byte
		 System.out.println("d+1 = " + result);
		 i = 3;
		 // i �� 3�� ��, 3�� 2�� ������? // 4����Ʈ�� 4����Ʈ�� ����߱⿡ ����� 4����Ʈ. ���� �Ҽ����� ������ ����(�� ����)
		 System.out.println("i/2 =" + i/2); // ����� 1.5�� �ƴ� 1
		 System.out.println("(double)i/2 =" + ((double)i/2)); // i�� double�� �����ϴ� ����� 1.5�� �ٲ�.
		 System.out.println("i/2.0 =" + i/2.0); // ������ ���� 2���� 2.0���� �����ϸ� ����� 1.5�� �ٲ�.
		 }
	}


