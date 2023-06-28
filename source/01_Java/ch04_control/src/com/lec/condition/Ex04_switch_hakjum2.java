package com.lec.condition;

import java.util.Scanner;

// 점수 (0~100)를 입력받아 학점 출력 
public class Ex04_switch_hakjum2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print
		("점수? ( 0 ~ 100) : ");
		int score = sc.nextInt();
		int temp = score == 100 ? 99 : score; // 101점 이상인 경우 오류가 나므로 100점일때만 99점으로 치환하여 case 9로 만들어줌 
		switch (temp / 10) { // score 대신 temp를 대입하여 if로 계산. 100점 입력시 99로 치환됨.
		case 9:
			System.out.println("A학점"); break;
		case 8:
			System.out.println("B학점"); break;
		case 7:
			System.out.println("C학점"); break;
		case 6:
			System.out.println("D학점"); break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("F학점"); break;
		default:
			System.out.println("유효하지 않은 점수"); break;
		}
		sc.close();
		/*
		 * if ((score >= 90) && (score < 100)) { // 2개를 만족. 괄호로 우선순위 설정가능. (안해도 되긴함)
		 * System.out.println("A학점"); } else if (score >= 80 && score < 90) { // 100보다
		 * 높은거 쓸 경우 오류남. score < 90을 넣어줘야 System.out.println("B학점"); } else if (score >=
		 * 70 && score < 80) { System.out.println("C학점"); } else if (score >= 60 &&
		 * score < 70) { System.out.println("D학점"); } else if (score >= 0 && score < 60)
		 * { System.out.println("F학점"); } else { System.out.println("유효하지 않은 점수");
		 * 
		 * } // else
		 */		sc.close();
		
	} //main
} // class
