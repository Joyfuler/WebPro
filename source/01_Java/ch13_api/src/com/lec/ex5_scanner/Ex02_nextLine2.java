package com.lec.ex5_scanner;

import java.util.Scanner;

// ���� - �̸� - 
public class Ex02_nextLine2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ���. : "); // nextInt�� ������ + \n �� ��. (\n�� ������ �ڿ� ����). ���� �����ʹ� ���� \n�� ����.
		int age = scanner.nextInt();
		System.out.println("�Է��� ���̴� " + age);
		System.out.print("������ �Է����ּ���. : ");
		scanner.nextLine(); // ���ۿ� �����ִ� \n�� ����� ����.
		String name = scanner.nextLine().trim(); // ȫ�浿(O), ��ũ����(O), �� ũ���� (x). white-space(�����̽�,��,\n) �ձ��� ������.
		System.out.println("�Է��� �̸��� " + name);
		System.out.print("�ּҸ� �Է����ּ���. :");
		 // �ƹ��͵� ���� �ʰ�, ��� �տ� �����ִ� \n�� �������ִ� ����.
		String address = scanner.nextLine().trim(); // �� ��� \n �պκб��� ������. ���ٿ� \n�� �����ִ� �����̹Ƿ�, �ƹ��͵� return���� ����. ���� \n�� ������.
		System.out.println("�Է��� �ּҴ� " + address); // ������ �� ũ��� ©���� ������ �߻�...
		System.out.println("��");
		
	}
}
