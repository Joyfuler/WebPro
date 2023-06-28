package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력해주세요.");
		int num = scanner.nextInt();
		if (num <0) {			
			num *= -1;
		}
		System.out.println("입력하신 수의 절대값은 " + num +"입니다");
		scanner.close();
	}
}
