package com.lec.method;

import java.util.Scanner;

public class Quiz {
	public static void gugudan(int num) {

		for (int i = 1; i <= 9; i++) {
			//int a = (num) * i;
			System.out.println(num + " x " + i + " = " + (num * i));
		} 
		

	}

	// main(usernum)이 아니라, 메인메소드에 gugudan(usernum); 을 넣고 num을 출력하자.

	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int usernum;
		System.out.println("출력을 원하는 구구단을 입력해주세요.");
		do {
			usernum = scanner.nextInt(); // usernum이 잘못된 경우 usernum 입력받기를 반복. 제대로 받은 경우 탈출함.
			System.out.println("잘못된 수입니다. 다시 한 번 입력해주세요.");
		} while (usernum <2 || usernum >9);
		
		gugudan(usernum);

	}
}
