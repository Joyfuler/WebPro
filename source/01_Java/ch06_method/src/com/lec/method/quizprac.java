package com.lec.method;

import java.util.Scanner;

public class quizprac {

	public static int num(int userNum) {
		for (int i = 1; i <= 9; i++) {
			System.out.println(userNum + "*" + i + " = " + (userNum * i));
		}
		return userNum;
	}

	public static void main(String[] args) {
		int userNum;
		Scanner scanner = new Scanner(System.in);
		System.out.println("����� ���ϴ� �������� �Է����ּ���.");
		do { 
		userNum = scanner.nextInt();
		System.out.println("�߸� �Է��߽��ϴ�. ���ϴ� �������� �ٽ� �Է����ּ���.");
		} while (userNum < 2 || userNum >9);
		num (userNum);
	} 
}
