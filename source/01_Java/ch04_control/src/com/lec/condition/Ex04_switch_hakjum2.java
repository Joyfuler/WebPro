package com.lec.condition;

import java.util.Scanner;

// ���� (0~100)�� �Է¹޾� ���� ��� 
public class Ex04_switch_hakjum2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print
		("����? ( 0 ~ 100) : ");
		int score = sc.nextInt();
		int temp = score == 100 ? 99 : score; // 101�� �̻��� ��� ������ ���Ƿ� 100���϶��� 99������ ġȯ�Ͽ� case 9�� ������� 
		switch (temp / 10) { // score ��� temp�� �����Ͽ� if�� ���. 100�� �Է½� 99�� ġȯ��.
		case 9:
			System.out.println("A����"); break;
		case 8:
			System.out.println("B����"); break;
		case 7:
			System.out.println("C����"); break;
		case 6:
			System.out.println("D����"); break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("F����"); break;
		default:
			System.out.println("��ȿ���� ���� ����"); break;
		}
		sc.close();
		/*
		 * if ((score >= 90) && (score < 100)) { // 2���� ����. ��ȣ�� �켱���� ��������. (���ص� �Ǳ���)
		 * System.out.println("A����"); } else if (score >= 80 && score < 90) { // 100����
		 * ������ �� ��� ������. score < 90�� �־���� System.out.println("B����"); } else if (score >=
		 * 70 && score < 80) { System.out.println("C����"); } else if (score >= 60 &&
		 * score < 70) { System.out.println("D����"); } else if (score >= 0 && score < 60)
		 * { System.out.println("F����"); } else { System.out.println("��ȿ���� ���� ����");
		 * 
		 * } // else
		 */		sc.close();
		
	} //main
} // class
