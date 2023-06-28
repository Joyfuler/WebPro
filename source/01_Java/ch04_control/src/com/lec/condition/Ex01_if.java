package com.lec.condition;

// 점수 할당 후 점수에 따른 결과를 출력
public class Ex01_if {
	public static void main(String[] args) {
		int score = 35;
		if (score >= 90) {
			System.out.println("완벽합니다");
		} else if (score >= 70){ // 70~ 89점사이
			System.out.println("뭐 완벽 안하네"); // if나 else는 꼭 괄호를 하나씩 넣어줄것
		} else if (score >= 60) { // 60 ~ 69점사이
			System.out.println("뭐 좀 분발하시던지");
		} else {
			System.out.println("재시험입니다.");
		}
		System.out.println("DONE");

	}
}
