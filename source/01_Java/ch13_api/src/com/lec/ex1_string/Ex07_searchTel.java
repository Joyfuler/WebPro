package com.lec.ex1_string;

import java.util.Scanner;

// ��ȭ��ȣ ���ڸ��� �ߺ����� �ʴ´ٴ� �����Ͽ�..
public class Ex07_searchTel {
	public static void main(String[] args) {
		String[] tels = { "010-9999-9999", "010-8888-8888", "010-7777-7777" };
		Scanner scanner = new Scanner(System.in);
		while (true) { System.out.println("�˻��� ����� ��ȭ��ȣ ���ڸ��� �Է����ּ���. �׸� �Ͻ÷��� X�� �Է����ּ���.");
		// while (true) ��������!
		String searchTel = scanner.next(); // "6666"?
		if (searchTel.equalsIgnoreCase("x")){
			break;
		}
		int i;
		for (i = 0; i < tels.length; i++) { // �迭�� �� ���� ��ȸ
			int postIdx = tels[i].lastIndexOf("-"); // postIdx�� ����, �� �迭�� ������ -�� �ִ� �迭�� ������.
			String postTel = tels[i].substring(postIdx + 1); // ��ȭ��ȣ ���ڸ��� ������ ����Ϸ��� �迭�� +1�� �ؾ�..
			if (postTel.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ��" + tels[i] + "�Դϴ�. ");
				break;
			}
		}
		if (i == tels.length) { // �ڵ��� ��ȣ�� ã�� ���Ѱ��
			System.out.println("�Է��Ͻ� ��ȭ��ȣ ���ڸ��� ã�� �� �����ϴ�. ȸ������ �� ...");
		}
		}
		scanner.close();

	}
}
