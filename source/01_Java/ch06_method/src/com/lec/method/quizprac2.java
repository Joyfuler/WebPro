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
		System.out.println("출력하길 원하는 단수를 입력해주세요.");
		int userNum;

		do {
			userNum = scanner.nextInt();
			System.out.println("다시 한 번 입력해주세요.");
		} while (userNum < 2 || userNum > 9);
		gugudan(userNum);
	}

}
