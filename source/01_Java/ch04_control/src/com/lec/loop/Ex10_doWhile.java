package com.lec.loop;

import java.util.Scanner;

// ����ڿ��� ���� �Է¹޾� ��������. ��ȿ�� ���� �Է�x�� �ݺ��ؼ� �����Է��ϵ���..
// ¦���� �Է¹޾� ����ϴ� ���α׷�..? (¦���� �ƴϸ� ¦���� �ٽ� �Է��ϰ� ��.)
public class Ex10_doWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// int num = scanner.nextInt(); 1ȸ�� �Է��ϴ� ��. �ݺ� ������? do while�� �̿�����.
		int num; // num�� �ٱ����� int �ο�����
		do {
			System.out.print("¦���� �Է��ϼ���: "); // ��ɹ�
			num = scanner.nextInt();
			// int num = scanner.nextInt(); --> ����. int num�� �ٱ����� ����� ��ȣ ���� num�� ����.
		} while(num %2 != 0); // ����
		System.out.println("�Է��Ͻ� ���� " + num);
		scanner.close();
	}
}
