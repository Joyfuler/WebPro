package com.lec.condition;

import java.util.Scanner;

// �� ���� �Է¹޾� �� ��° ���� �󸶸�ŭ �� ū�� ���
public class Ex02_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // �빮�� = ��ü ������ Ÿ��.. �Է� ��ġ�� ��ĵ�ϴ� ���
		System.out.println("ù ��° ����: ");
		int num1 = scanner.nextInt();
		System.out.println("�� ��° ����: ");
		int num2 = scanner.nextInt();
		if (num1 > num2) {
			System.out.printf("ù ��° �� (%d)�� %d��ŭ �� Ů�ϴ�\n", num1, (num1 - num2));
		} else if (num1 < num2) {
			System.out.printf("�� ��° �� (%d)�� %d��ŭ �� Ů�ϴ�\n", num2, (num2 - num1));
		} else {
			System.out.println("�� ���� �����ϴ�.");
			scanner.close();
		}
	}
}
