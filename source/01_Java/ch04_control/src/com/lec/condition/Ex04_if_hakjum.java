package com.lec.condition;

import java.util.Scanner;

// 점수 (0~100)를 입력받아 학점 출력 
public class Ex04_if_hakjum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print
		("점수? ( 0 ~ 100) : ");
		int score = sc.nextInt();
		if ((score >= 90) && (score <= 100)) { // 2개를 만족. 괄호로 우선순위 설정가능. (안해도 되긴함)
			System.out.println("A학점");
		} else if (score >= 80 && score < 90) { // 100보다 높은거 쓸 경우 오류남. score < 90을 넣어줘야
			System.out.println("B학점");
		} else if (score >= 70 && score < 80) { 
			System.out.println("C학점");
		} else if (score >= 60 && score < 70) { 
			System.out.println("D학점");
		} else if (score >= 0 && score < 60) { 
			System.out.println("F학점");
		} else {
			System.out.println("유효하지 않은 점수");
		
		} // else
		sc.close();
		
	} //main
} // class
