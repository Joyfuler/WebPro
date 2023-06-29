package com.lec.loopQuiz;

import java.util.Scanner;

//가위바위보 게임
public class Homework1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) { // 항상 반복실행. (혹은 result를 위에 설정해서 int result = 0으로 설정한 뒤, 괄호 안에 있는 result의 값을 재설정해도 됨
			System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택하세요. \n(-1) 입력시 게임이 종료됩니다.\n 이 게임은 당신이 패배할 때까지 반복됩니다.");
			int result = scanner.nextInt(); // 0,1,2
			if (result == -1) {
				System.out.println("나 간다");
				break;
			}

			// -1인 경우 꺼짐.
			if (result < -1 || result > 2) { // 0,1,2,-1 이외의 수를 입력할 경우 처음부터.
				System.out.println("잘못 입력했으므로 처음부터 다시 시작합니다.");
				continue; // 잘못 입력한 경우 처음부터.
			}
			int computer = ((int) (Math.random() * 3)); // 0이상 3 미만의 정수를 가져오려면? 0 <= Math.random() < 1 의 각 항에 3을 곱해줌.
			if (result == 0) {
				System.out.println("가위를 냈습니다.");
			} else if (result == 1) {
				System.out.println("바위를 냈습니다.");
			} else if (result == 2) {
				System.out.println("보를 냈습니다.");
			} else {
				System.out.println("잘못 입력했습니다.");
			
			
			// String txt1 = (result == 0) ? "가위를 냈습니다" : (result == 1) ? "바위를 냈습니다." : 보를 냈습니다.
			// 혹은 삼항식으로도 가능
				
			

			}
			switch (computer) {
			case 0:
				System.out.println("컴퓨터는 가위를 냈습니다.");
				break;
			case 1:
				System.out.println("컴퓨터는 바위를 냈습니다.");
				break;
			case 2:
				System.out.println("컴퓨터는 보를 냈습니다.");
				break;
			}

			if ((result + 1) % 3 == computer) {
				System.out.println("당신이 이겼습니다!");

			}
			if (result % 3 == computer) {
				System.out.println("비겼습니다.");
			}
			if ((result + 2) % 3 == computer) {
				System.out.println("당신이 패배했습니다.");
				System.out.println("게임을 종료합니다.");
				System.exit(0);

			} // if

		} // while
		System.out.println("가위바위보 게임을 종료합니다.");
		scanner.close();
	}
}
