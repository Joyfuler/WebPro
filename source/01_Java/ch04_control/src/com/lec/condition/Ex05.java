package com.lec.condition;

import java.util.Scanner;

// ����ڷκ��� ���� ������ Ȧ������ ¦������ ��� (���׿�����, if, switch)
// �� ������ switch�� ���
public class Ex05 {
	public static void main(String[] args) {
		Scanner jungsu = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���: ");
		int num = jungsu.nextInt();
		switch (num % 2) { // 2�� ���������� ������ 
		case 0:
			System.out.println("¦���Դϴ�.");
			break;
		case 1:
			System.out.println("Ȧ���Դϴ�.");
			break;
		case -1:
			System.out.println("Ȧ���Դϴ�.");
			break;
			
		default:
			System.out.println("�߸��� �����Դϴ�..");
			break;
		}
		jungsu.close(); // ��ĳ�� �ݴ��۾�
				
	}
}
