package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("����� ���̸� �Է����ּ���: " );
		
		int year = scan.nextInt();
		if (year >= 65) {
			System.out.println("��ο���Դϴ�.");
		} else {
			System.out.println("�Ϲ��Դϴ�.");
		}
			
		}
	}

