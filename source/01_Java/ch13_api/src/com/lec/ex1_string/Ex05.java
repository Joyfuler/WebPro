package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tellNo;
		while (true){ // true���̴� �翬�� ���ѹݺ�.
			System.out.println("��ȭ��ȣ�� �Է����ּ���. �������� X�� �����ּ���.");

			tellNo = scanner.next();
		    if(tellNo.equalsIgnoreCase("x")) { // if���� ������ �Է� ���Ŀ� ����޵���. �׷��� ������ �Ʒ��� �� ������..
		    	break; // x�� ���� �� break�� �ɸ��� ��ȣ ������ �ٷ� �Ѿ�� ��.
		    }
			System.out.println("�Է��� ��ȭ��ȣ: " + tellNo);
			System.out.print("¦����° ���ڿ�: ");
			for (int i = 0; i < tellNo.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tellNo.charAt(i) + " ");
				}
			}
			System.out.print("\n���ڸ� �Ųٷ� : ");
			for (int idx = tellNo.length()-1; idx >= 0; idx--) { // �� �ޱ��� ��ȣ���� �ݺ����� ���. length() -1�� ����!
				System.out.print(tellNo.charAt(idx));
			}
			int preIdx = tellNo.indexOf("-");
			System.out.print("\n��ȭ��ȣ �� ���ڸ���: ");
			System.out.println(tellNo.substring(0, preIdx));
			System.out.print("��ȭ��ȣ ���ڸ���: ");
			System.out.println(tellNo.substring(tellNo.lastIndexOf("-") + 1, tellNo.length()));
		} 
		System.out.println("�Է��� �����մϴ�.");
		scanner.close();
	}
}
