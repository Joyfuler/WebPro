package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ �Է����ּ���.");
		int num = scanner.nextInt();
		if (num <0) {			
			num *= -1;
		}
		System.out.println("�Է��Ͻ� ���� ���밪�� " + num +"�Դϴ�");
		scanner.close();
	}
}
