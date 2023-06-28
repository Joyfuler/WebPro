package com.lec.conditionQuiz;

import java.util.Scanner;

public class QUiz_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("가위바위보를 합니다. 0은 가위, 1은 바위, 2는 보입니다. 셋 중 하나를 입력하세요: ");
		int result = scanner.nextInt();
		int com = (int)(Math.random() *	3); 
			if (result == 0) {
			System.out.println("가위를 냈습니다.");
		}	else if (result == 1) {
			System.out.println("바위를 냈습니다.");
		} 	else if (result == 2) {
			System.out.println("보를 냈습니다.");
		} 	else {
			System.out.println("잘못 입력하셨습니다.");
		}
			// 혹은 switch로도 사용할 수 있음
			switch (result) {
			case 0 : System.out.println("가위를 냈습니다."); break;
			case 1 : System.out.println("바위를 냈습니다."); break;
			case 2 : System.out.println("보를 냈습니다."); break;
			default : System.out.println("잘못 입력하셨습니다."); break;
			}
			
			// 혹은 삼항식으로도 사용가능.
			String result2 = (result ==0) ? "가위를 냈습니다." : ( (result ==1) ? "바위를 냈습니다." : "보를 냈습니다.");
			if (result >2 || result <0) {
				System.out.println("잘못 입력하셨습니다.");
				System.exit(0); // 프로그램 강제종료 명령어
				System.out.println(result2);
			}
				
			if ( com == 0) { 
				System.out.println("컴퓨터는 가위를 냈습니다");
			} else if ( com == 1) {
				System.out.println("컴퓨터는 바위를 냈습니다.");
			} else if ( com == 2) {
				System.out.println("컴퓨터는 보를 냈습니다.");
			} else {
				System.out.println("잘못 입력하셨습니다.");
					}
			// 가위바위보 가짓수
			if ( com == 0 && result == 0) {
				System.out.println("비겼습니다.");
			}
			if ( com == 0 && result == 1) {
				System.out.println("이겼습니다!");
				
			}
			if ( com == 0 && result == 2) {
				System.out.println("졌습니다..");
			}			
			if ( com == 1 && result == 0) {
				System.out.println("졌습니다..");
			}
			if ( com == 1 && result == 1) {
				System.out.println("비겼습니다.");
			}
			if ( com == 1 && result == 2) {
				System.out.println("이겼습니다!");
			}
			if ( com == 2 && result == 0) {
				System.out.println("이겼습니다!.");
			}
			if ( com == 2 && result == 1) {
				System.out.println("졌습니다..");				
			}
			if ( com == 2 && result == 2) {
				System.out.println("비겼습니다.");
			}			
			scanner.close();
			}
		
	}


