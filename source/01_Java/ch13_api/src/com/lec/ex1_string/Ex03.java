package com.lec.ex1_string;

import java.util.Scanner;

// ����ڰ� x�� �Է��� ������ �ݺ�
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.println("������ ���͵帱���? I: input, U: update, D: delete, X : exit");
			fn = scanner.next(); // i,I,U,u,d,D,x,X, ���...
			switch (fn) {
			case "I":
			case "i":
				System.out.println("�Է� ����");
				break;
			case "U":
			case "u":
				System.out.println("������Ʈ ����");
				break;
			case "D":
			case "d":
				System.out.println("���� ����");
				break;
			}

		// } while (!fn.equals("x") && !fn.equals("X")); // x�� �ƴϸ� ��� ��. (fn �տ� !)
		} while (!fn.equalsIgnoreCase("x"));
		System.out.println("�����մϴ�.");
		scanner.close();
	}
}
