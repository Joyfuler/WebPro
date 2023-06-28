package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("계절을 알고 싶은 월 수를 입력하세요: (1~12)월");
		int month = scanner.nextInt();
		switch (month) {
	case 1: case 2: case 12:
		System.out.println( month + "월은 겨울입니다."); break;
	case 3: case 4: case 5:
		System.out.println( month + "월은 봄입니다."); break;
	case 6: case 7: case 8:
		System.out.println( month + "월은 여름입니다."); break;
	case 9: case 10: case 11:
		System.out.println( month + "월은 가을입니다."); break;
	default:
			System.out.println("잘못 입력하셨습니다."); break;
	}
		scanner.close();
	}
}
