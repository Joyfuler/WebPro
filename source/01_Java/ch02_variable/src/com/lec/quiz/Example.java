package com.lec.quiz;

public class Example {
public static void main(String[] args) {
	int kr = 98; // 국어점수 98점
	double eng = 89.9; // 영어점수 89.9점
	int math = 56; // 수학점수 56점
	double total = (kr + eng + math);
	double average = (kr + eng + math) / 3;
	System.out.printf("내 국어 영어 수학의 총 점수 = %.1f 입니다. \n", total);
	System.out.printf("내 국어 영어 수학의 평균 점수 = %.1f 입니다.",	average);
			
			}
}
