package com.lec.conditionQuiz;

import java.util.Scanner;

public class QUiz_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("������������ �մϴ�. 0�� ����, 1�� ����, 2�� ���Դϴ�. �� �� �ϳ��� �Է��ϼ���: ");
		int result = scanner.nextInt();
		int com = (int)(Math.random() *	3); 
			if (result == 0) {
			System.out.println("������ �½��ϴ�.");
		}	else if (result == 1) {
			System.out.println("������ �½��ϴ�.");
		} 	else if (result == 2) {
			System.out.println("���� �½��ϴ�.");
		} 	else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
			// Ȥ�� switch�ε� ����� �� ����
			switch (result) {
			case 0 : System.out.println("������ �½��ϴ�."); break;
			case 1 : System.out.println("������ �½��ϴ�."); break;
			case 2 : System.out.println("���� �½��ϴ�."); break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�."); break;
			}
			
			// Ȥ�� ���׽����ε� ��밡��.
			String result2 = (result ==0) ? "������ �½��ϴ�." : ( (result ==1) ? "������ �½��ϴ�." : "���� �½��ϴ�.");
			if (result >2 || result <0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.exit(0); // ���α׷� �������� ��ɾ�
				System.out.println(result2);
			}
				
			if ( com == 0) { 
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
			} else if ( com == 1) {
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
			} else if ( com == 2) {
				System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					}
			// ���������� ������
			if ( com == 0 && result == 0) {
				System.out.println("�����ϴ�.");
			}
			if ( com == 0 && result == 1) {
				System.out.println("�̰���ϴ�!");
				
			}
			if ( com == 0 && result == 2) {
				System.out.println("�����ϴ�..");
			}			
			if ( com == 1 && result == 0) {
				System.out.println("�����ϴ�..");
			}
			if ( com == 1 && result == 1) {
				System.out.println("�����ϴ�.");
			}
			if ( com == 1 && result == 2) {
				System.out.println("�̰���ϴ�!");
			}
			if ( com == 2 && result == 0) {
				System.out.println("�̰���ϴ�!.");
			}
			if ( com == 2 && result == 1) {
				System.out.println("�����ϴ�..");				
			}
			if ( com == 2 && result == 2) {
				System.out.println("�����ϴ�.");
			}			
			scanner.close();
			}
		
	}


