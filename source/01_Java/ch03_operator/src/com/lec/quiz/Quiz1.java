package com.lec.quiz;

import java.util.Scanner;

// ����ڷκ��� ���� �Է¹޾� �Է¹��� ���� 3�� ������� ���θ� ���.
public class Quiz1 {
	public static void main(String[] args) {
//		int a =10; // ���� ������ ������ ��.
//		String name = "ȫ�浿;  // ���� ������ ���ڿ� �Է�.. but ����ڰ� �Է��� ���ڿ��� ����������?
//		String name = new string ("ȫ�浿");
		Scanner sc = new Scanner(System.in);  // String�� ���������� ��ü ������ Ÿ��. �Է½� �ڵ� �ϼ����� import java.util.scanner �޼ҵ尡 �Էµ�
		// ������ Scanner�̰�, input ��ġ�κ��� ��ĳ���ϵ��� ����.  
		System.out.print("������ �Է��ϼ��� : ");
		int su = sc.nextInt(); // Ű����κ��� �Է¹��� ������ su�� �Ҵ���.
		String result = (su % 3 == 0)? "3�� ����Դϴ�" : "3�� ����� �ƴմϴ�.";
		// System.out.println("�Է��Ͻ� �� (" + su  + " ) �� + result);
		System.out.printf("�Է��Ͻ� �� (%d)�� %s", su, result);
		sc.close();
	
	}
}
