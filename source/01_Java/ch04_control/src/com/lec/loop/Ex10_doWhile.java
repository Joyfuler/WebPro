package com.lec.loop;

import java.util.Scanner;

// 사용자에게 정수 입력받아 학점구함. 유효한 숫자 입력x시 반복해서 학점입력하도록..
// 짝수를 입력받아 출력하는 프로그램..? (짝수가 아니면 짝수를 다시 입력하게 함.)
public class Ex10_doWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// int num = scanner.nextInt(); 1회만 입력하는 것. 반복 실행은? do while을 이용하자.
		int num; // num을 바깥에서 int 부여해줌
		do {
			System.out.print("짝수를 입력하세요: "); // 명령문
			num = scanner.nextInt();
			// int num = scanner.nextInt(); --> 오류. int num을 바깥으로 빼줘야 괄호 밖의 num도 계산됨.
		} while(num %2 != 0); // 조건
		System.out.println("입력하신 수는 " + num);
		scanner.close();
	}
}
