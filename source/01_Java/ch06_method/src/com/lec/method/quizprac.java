package com.lec.method;

import java.util.Scanner;

public class quizprac {

	public static int num(int userNum) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(userNum + "*" + i + " = " + (userNum * i));
		}
		return userNum;
	}

	public static void main(String[] args) {
		int userNum;
		Scanner scanner = new Scanner(System.in);
		System.out.println("출력을 원하는 구구단을 입력해주세요.");
		do { 
		userNum = scanner.nextInt();
		System.out.println("잘못 입력했습니다. 원하는 구구단을 다시 입력해주세요.");
		} while (userNum < 2 || userNum >9);
		num (userNum);
	} 
}
