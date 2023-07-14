package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class PracMain {
	public static void main(String[] args) {
		String name, tel, address;
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N) ");
		
		String answer = scanner.nextLine();
		if (answer.equalsIgnoreCase("n")) {
			System.out.println("ȸ�� ������ �����մϴ�.");
			break;
		}
		System.out.println("����� �̸��� �Է����ּ���. :");
		name = scanner.nextLine();
		System.out.println("����� ��ȭ��ȣ�� �Է����ּ���. : ");
		tel = scanner.nextLine();
		System.out.println("����� �ּҸ� �Է����ּ���.");
		address = scanner.nextLine();
		System.out.println("������ �ּż� �����մϴ�.");
		customers.add(new Customer(name, tel, address));
		
		}
		if (customers.size() == 0) {
			System.out.println("���� ���Ե� ȸ���� �����ϴ�.");
		} else {
			System.out.println("���� ���ԵǾ� �ִ� ȸ�� ����Դϴ�.");
			for (Customer customer : customers) {
				System.out.println(customer);
			
			}
		}

	}

}
