package com.lec.ex5_scanner;

import java.util.Scanner;

// ���� - �̸� - 
public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ���. : "); // nextInt�� ������ + \n �� ��. (\n�� ������ �ڿ� ����). ���� �����ʹ� ���� \n�� ����.
		int age = scanner.nextInt();
		System.out.println("�Է��� ���̴� " + age);
		System.out.print("������ �Է����ּ���. : ");
		String name = scanner.next(); // ȫ�浿(O), ��ũ����(O), �� ũ���� (x). white-space(�����̽�,��,\n) �ձ��� ������.
		System.out.println("�Է��� �̸��� " + name);
		System.out.print("�ּҸ� �Է����ּ���. :");
		scanner.nextLine(); // �ƹ��͵� ���� �ʰ�, ��� �տ� �����ִ� \n�� �������ִ� ����.
		String address = scanner.nextLine(); // �� ��� \n �պκб��� ������. ���ٿ� \n�� �����ִ� �����̹Ƿ�, �ƹ��͵� return���� ����. ���� \n�� ������.
		System.out.println("�Է��� �ּҴ� " + address); // ������ �� ũ��� ©���� ������ �߻�...
		System.out.println("��");
		
	}
}
