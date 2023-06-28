package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
public static void main(String[] args) {
	Scanner scan1 = new Scanner(System.in);
	
	System.out.println("국어 점수를 입력해주세요: ");
	int kor = scan1.nextInt();

	System.out.println("영어 점수를 입력해주세요: ");
	int eng = scan1.nextInt();


System.out.println("수학 점수를 입력해주세요: ");
	int mat = scan1.nextInt();
	
	int all = (kor + eng + mat);
	System.out.printf("당신의 국어 성적은 %d, 영어 성적은 %d, 수학 성적은 %d 입니다.", kor, eng, mat);
	System.out.println("\n당신의 총점은 " + all + " 점이며, ");
	System.out.println("당신의 평균 점수는 " + ((int)all / 3.0) + "점입니다.");
			
}
}
