package com.lec.ex5_scanner;

import java.util.Scanner;

// �̸�(�� ũ����or ȫ�浿) -> �ּ� -> ����
public class Ex03 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("�̸��� �Է����ּ��� : ");
	String name = scanner.nextLine();
	System.out.println("�ּҸ� �Է����ּ��� : ");
	String adress = scanner.nextLine(); // nextline�� ��� ��ġ�� ����. ���ۿ� \n�� �������� ���� �������...
	System.out.println("���̸� �Է����ּ��� :");
	int age = scanner.nextInt();
	System.out.println(name + "��" + age + "��, " + adress + " ����");
			
}
}
