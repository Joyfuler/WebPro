package com.lec.conditionQuiz;

import java.util.Scanner;

//���������� ����
public class Quiz_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����(0), ����(1), ��(2) �� �ϳ��� �����ϼ���. \n(-1) �Է½� ������ ����˴ϴ�.");
		int result = scanner.nextInt(); // 0,1,2
		while (result == -1) {
			System.out.println("���������� ������ �����մϴ�.");
			System.exit(0);
		}

		int computer = ((int) (Math.random() * 3)); // 0�̻� 3 �̸��� ������ ����������? 0 <= Math.random() < 1 �� �� �׿� 3�� ������.
		if (result == 0) {
			System.out.println("������ �½��ϴ�.");
		} else if (result == 1) {
			System.out.println("������ �½��ϴ�.");
		} else if (result == 2) {
			System.out.println("���� �½��ϴ�.");
		} else {
			System.out.println("�߸� �Է��߽��ϴ�.");

		}
		switch (computer) {
		case 0:
			System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
			break;
		case 1:
			System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
			break;
		case 2:
			System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
			break;
		}
		if ((result + 2) % 3 == computer) {
			System.out.println("����� �̰���ϴ�!");
			

		}
		if ((result + 1) % 3 == computer) {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�!");
			
				
		}
		if (result % 3 == computer) {
			System.out.println("�����ϴ�.");
			
			
		} 

		scanner.close();

	}
}
