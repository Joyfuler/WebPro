package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("������ Ȯ���� �ֹι�ȣ�� �Է����ּ���.");
		String juminNo = scanner.next();
		String genderStr = juminNo.substring(7, 8);
			// but �ֹι�ȣ ���ڸ��� string�� ���ڷ� ��ȯ�Ѵٸ�?
			int genderInt = Integer.parseInt(genderStr); // genderStr�� ���ڷ� ��ȯ�ϴ� �Լ�. integer.parseint...
			if (genderInt == 1 || genderInt == 3) {
				System.out.println("�����Դϴ�.");
			} else if (genderInt == 2 || genderInt == 4) {
				System.out.println("�����Դϴ�.");
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

