package com.lec.loopQuiz;

import java.util.Scanner;

//���������� ����
public class Homework1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("����(0), ����(1), ��(2) �� �ϳ��� �����ϼ���. \n(-1) �Է½� ������ ����˴ϴ�.\n �� ������ ����� �й��� ������ �ݺ��˴ϴ�.");
			int result = scanner.nextInt(); // 0,1,2
			if (result == -1) break; // -1�� ��� ����.
			if (result<-1 || result>2) continue; // �߸� �Է��� ��� ó������.
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
			
			if ((result + 1) % 3 == computer) {
				System.out.println("����� �̰���ϴ�!");
	
			}
			if (result % 3 == computer) {
				System.out.println("�����ϴ�.");
			}
			if ((result + 2) % 3 == computer) {
				System.out.println("����� �й��߽��ϴ�.");
				System.out.println("������ �����մϴ�.");
				System.exit(0);
			
			}//if
		
		}//while
		System.out.println("���������� ������ �����մϴ�.");
		scanner.close();
	}
}
