package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
public static void main(String[] args) {
	Scanner scan1 = new Scanner(System.in);
	
	System.out.println("���� ������ �Է����ּ���: ");
	int kors = scan1.nextInt();

	System.out.println("���� ������ �Է����ּ���: ");
	int engs = scan1.nextInt();


System.out.println("���� ������ �Է����ּ���: ");
	int mats = scan1.nextInt();
	
	int all = (kors + engs + mats);
	System.out.printf("����� ���� ������ %d, ���� ������ %d, ���� ������ %d �Դϴ�.", kors, engs, mats);
	System.out.println("\n����� ������ " + all + " ���̸�, ");
	System.out.println("����� ��� ������ " + ((int)all / 3.0) + "���Դϴ�.");
			
}
}
