package com.lec.condition;

import java.util.Scanner;

// 두 수를 입력받아 몇 번째 수가 얼마만큼 더 큰지 출력
public class Ex02_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 대문자 = 객체 데이터 타입.. 입력 장치를 스캔하는 기능
		System.out.println("첫 번째 수는: ");
		int num1 = scanner.nextInt();
		System.out.println("두 번째 수는: ");
		int num2 = scanner.nextInt();
		if (num1 > num2) {
			System.out.printf("첫 번째 수 (%d)가 %d만큼 더 큽니다\n", num1, (num1 - num2));
		} else if (num1 < num2) {
			System.out.printf("두 번째 수 (%d)가 %d만큼 더 큽니다\n", num2, (num2 - num1));
		} else {
			System.out.println("두 수가 같습니다.");
			scanner.close();
		}
	}
}
