package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("당신의 나이를 입력해주세요: " );
		
		int year = scan.nextInt();
		if (year >= 65) {
			System.out.println("경로우대입니다.");
		} else {
			System.out.println("일반입니다.");
		}
			
		}
	}

