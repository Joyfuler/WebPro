package com.lec.method;

import java.util.Scanner;

public class Quiz {
	public static void gugudan(int num) {

		for (int i = 1; i <= 9; i++) {
			//int a = (num) * i;
			System.out.println(num + " x " + i + " = " + (num * i));
		} 
		

	}

	// main(usernum)�� �ƴ϶�, ���θ޼ҵ忡 gugudan(usernum); �� �ְ� num�� �������.

	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int usernum;
		System.out.println("����� ���ϴ� �������� �Է����ּ���.");
		do {
			usernum = scanner.nextInt(); // usernum�� �߸��� ��� usernum �Է¹ޱ⸦ �ݺ�. ����� ���� ��� Ż����.
			System.out.println("�߸��� ���Դϴ�. �ٽ� �� �� �Է����ּ���.");
		} while (usernum <2 || usernum >9);
		
		gugudan(usernum);

	}
}
