package com.lec.quiz;

import java.util.Scanner;

// 사용자로부터 수를 입력받아 입력받은 수가 3의 배수인지 여부를 출력.
public class Quiz1 {
	public static void main(String[] args) {
//		int a =10; // 직접 변수에 대입한 것.
//		String name = "홍길동;  // 직접 변수에 문자열 입력.. but 사용자가 입력한 문자열을 가져오려면?
//		String name = new string ("홍길동");
		Scanner sc = new Scanner(System.in);  // String과 마찬가지로 객체 데이터 타입. 입력시 자동 완성으로 import java.util.scanner 메소드가 입력됨
		// 변수는 Scanner이고, input 장치로부터 스캐닝하도록 해줌.  
		System.out.print("정수를 입력하세요 : ");
		int su = sc.nextInt(); // 키보드로부터 입력받은 정수를 su에 할당함.
		String result = (su % 3 == 0)? "3의 배수입니다" : "3의 배수가 아닙니다.";
		// System.out.println("입력하신 수 (" + su  + " ) 는 + result);
		System.out.printf("입력하신 수 (%d)는 %s", su, result);
		sc.close();
	
	}
}
