package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ù��° ���ڸ� �Է��ϼ���. : ");
		int a = scanner.nextInt();
		System.out.println("�ι�° ���ڸ� �Է��ϼ���. : ");
		int b = scanner.nextInt();
		
		char result = (a == b) ? 'O' : 'X';
		char result2 = (a > b) ? 'O' : 'X';
		System.out.println("�Է��� "+ a + "�� " + b + "�� ���� ���ϱ��? " + result);
		System.out.println("�Է���" + a + "�� " + b + "���� Ŭ���? " + result2);
		scanner.close();
	}
}
