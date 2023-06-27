package com.lec.ex;
// 산술 연산자: + - * / (나누기, 정수끼리 나누면 몫 연산자: 3나누기 2는 1) %
public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result; double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		// 숫자 더하기 숫자 = 숫자를 표시하고 싶을 때. 각 형식을 표시해 준 뒤 해당 변수와 문자 기입.
		// sysout.printf("%d %c %d = %d\n", n1, '-', n2, result);
		
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
		// 이 경우 정수와 정수로 나눴기에 몫만 남는 몫 연산. 3.3 (x) --> 3
		resultDouble = (double) n1 / n2;
		System.out.printf("%d %c %d = %.1f\n", n1, '/', n2, resultDouble); // .1f로 1자리 소숫점까지
		
		result =n1 % n2; // n1에 n2를 나눈 나머지
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result); // 33을 10으로 나눈 나머지 = 3
		// 나머지 연산자의 용도 : 짝수/홀수 판별, 배수 판별용도 ex 나머지가 2인 사람을 선발...
		if (n1%2 == 0) {
			System.out.println("n1은 짝수입니다.");
		} else {
				System.out.println("n1은 홀수입니다.");
				
			}
		
		if (n1%5 ==	0) { // 나머지가 0일 때 if (조건) {참일때 수행명령}; else {거짓일때 수행명령};
			System.out.println("n1은 5의 배수입니다.");
		} else {
			System.out.println("n1은 5의 배수가 아닙니다.");
		}
		}
	
		
	}
