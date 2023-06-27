package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 두개를 입력하세요.");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		char result = (a == b) ? 'O' : 'X';
		char result2 = (a > b) ? 'O' : 'X';
		System.out.println("입력한 "+ a + "과 " + b + "은 같은 수일까요? " + result);
		System.out.println("입력한" + a + "는 " + b + "보다 클까요? " + result2);
		
	}
}
