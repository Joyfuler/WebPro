package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain2 {
	public static void main(String[] args) {
		String name;
		String tel;
		String address;
		HashMap<String, Customer> hashmap = new HashMap<String, Customer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("ȸ�� ������ �����Ͻðڽ��ϱ�? (y/n, n�� �Է� �� ȸ�� ����Ʈ�� ���)");
		String answer = scanner.nextLine();
		while (true) {
			if (answer.equalsIgnoreCase("x") && hashmap.size() != 0) {
				break;
			} else if (answer.equalsIgnoreCase("x") && hashmap.size() == 0) {
				System.out.println("���� ȸ���� �����ϴ�.");
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
		}

	}


