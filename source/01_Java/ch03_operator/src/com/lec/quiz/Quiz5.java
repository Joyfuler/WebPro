package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
public static void main(String[] args) {
	Scanner scan1 = new Scanner(System.in);
	
	System.out.println("���� ������ �Է����ּ���: ");
	int kor = scan1.nextInt();

	System.out.println("���� ������ �Է����ּ���: ");
	int eng = scan1.nextInt();


System.out.println("���� ������ �Է����ּ���: ");
	int mat = scan1.nextInt();
	
	int all = (kor + eng + mat);
	System.out.printf("����� ���� ������ %d, ���� ������ %d, ���� ������ %d �Դϴ�.", kor, eng, mat);
	System.out.println("\n����� ������ " + all + " ���̸�, ");
	System.out.println("����� ��� ������ " + ((int)all / 3.0) + "���Դϴ�.");
			
}
}
