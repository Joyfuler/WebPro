package com.lec.loopQuiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ϴ� ������ �ܼ��� �Է����ּ���.");
		int start = 1;
		int result = scanner.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.println(result + " X " + start + " = " + (result * start));
			start += 1;
		}
		scanner.close();
	}

}
