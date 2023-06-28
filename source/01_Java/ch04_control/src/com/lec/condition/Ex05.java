package com.lec.condition;

import java.util.Scanner;

// 사용자로부터 받은 정수가 홀수인지 짝수인지 출력 (삼항연산자, if, switch)
// 본 예제는 switch를 사용
public class Ex05 {
	public static void main(String[] args) {
		Scanner jungsu = new Scanner(System.in);
		System.out.println("숫자를 입력하세요: ");
		int num = jungsu.nextInt();
		switch (num % 2) { // 2로 나눴을때의 나머지 
		case 0:
			System.out.println("짝수입니다.");
			break;
		case 1:
			System.out.println("홀수입니다.");
			break;
		case -1:
			System.out.println("홀수입니다.");
			break;
			
		default:
			System.out.println("잘못된 숫자입니다..");
			break;
		}
		jungsu.close(); // 스캐너 닫는작업
				
	}
}
