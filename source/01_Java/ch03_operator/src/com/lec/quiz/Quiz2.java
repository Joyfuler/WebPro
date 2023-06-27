package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
	Scanner number = new Scanner(System.in);
	System.out.print("정수를 입력하세요 : ");
	int su = number.nextInt();
	String result = (su % 2 ==0) ? "짝수입니다." : "홀수입니다.";
	System.out.println("입력하신 수 (" + su + ")는 " + result);
	number.close();
	}
}
