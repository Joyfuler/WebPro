package com.lec.ex1_string;

import java.util.Scanner;

// ��ȭ��ȣ ���ڸ��� �ߺ��ȴٸ�?
public class Ex07_searchTel2 {
	public static void main(String[] args) {
		String[] tels = { "010-9999-9999", "010-8888-7777", "010-7777-7777" }; // 7777 �� �ߺ��Ǵ� ��ȭ��ȣ 2��
		Scanner scanner = new Scanner(System.in);
		while (true) { System.out.println("�˻��� ����� ��ȭ��ȣ ���ڸ��� �Է����ּ���. �׸� �Ͻ÷��� X�� �Է����ּ���.");
		// while (true) ��������!
		boolean searchOk = false; // �ߺ��� ��ȭ��ȣ�� �ִ� ��� - boolean�� false�� ������ �� ã���� true�� ����
		String searchTel = scanner.next(); // "7777"?
		if (searchTel.equalsIgnoreCase("x")){
			break;
		}
		
		for (int i = 0; i < tels.length; i++) { // �迭�� �� ���� ��ȸ
			int postIdx = tels[i].lastIndexOf("-"); // postIdx�� ����, �� �迭�� ������ -�� �ִ� �迭�� ������.
			String postTel = tels[i].substring(postIdx + 1); // ��ȭ��ȣ ���ڸ��� ������ ����Ϸ��� �迭�� +1�� �ؾ�..
			if (postTel.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ��" + tels[i] + "�Դϴ�. ");
				searchOk = true; // ã���� ���, seachOk�� true�� ����� ��.
			}
		}
		if (!searchOk) { // �ڵ��� ��ȣ�� ã�� ���Ѱ��. !searchOk = ( seachOk == false)
			System.out.println("�Է��Ͻ� ��ȭ��ȣ ���ڸ��� ã�� �� �����ϴ�. ȸ������ �� ...");
		}
		}
		scanner.close();

	}
}
