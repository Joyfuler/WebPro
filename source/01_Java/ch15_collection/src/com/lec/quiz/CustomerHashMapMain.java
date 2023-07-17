package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {
	public static void main(String[] args) {
		String name, tel, address;
		HashMap<String, Customer> hashmap = new HashMap<String, Customer>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("ȸ�� ������ �����Ͻðڽ��ϱ�? (y/n, n�� �Է� �� ȸ�� ����Ʈ�� ���)");
			String answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("n") && (hashmap.size() != 0)) {
				break; // �ٷ� �Ʒ��� ȸ������ ����Ʈ�� �̵�.
			} else if (answer.equalsIgnoreCase("n") && (hashmap.isEmpty())) {
				System.out.println("���� ������ ȸ���� �����ϴ�.");
				continue;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("����� �̸��� �Է����ּ���.");
				name = scanner.nextLine();
				System.out.print("����� ��ȭ��ȣ�� �Է����ּ���.");
				tel = scanner.nextLine();
				System.out.print("����� �ּҸ� �Է����ּ���.");
				address = scanner.nextLine();
				hashmap.put(tel, new Customer(name, tel, address));
			}
		}
		Iterator<String> iterator = hashmap.keySet().iterator(); // unreachable.. ���� �ʴ´ٴ� ��. if�� ������ ������ �� ���ǹ��� �� ���ͼ�
																	// �߻��ϴ� ����...
		System.out.println("---------------ȸ������ ����Ʈ--------------");
		while (iterator.hasNext()) {
			String information = iterator.next();
			System.out.println(hashmap.get(information));

		}
	}
}
