package com.lec.method;

import java.util.Scanner;

public class quizprac2 {
	public static int gugudan(int userNum) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(userNum + "*" + i + "=" + (userNum * i));
		}
		return userNum;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����ϱ� ���ϴ� �ܼ��� �Է����ּ���.");
		int userNum;

		do {
			userNum = scanner.nextInt();
			System.out.println("�ٽ� �� �� �Է����ּ���.");
		} while (userNum < 2 || userNum > 9);
		gugudan(userNum);
	}

}
