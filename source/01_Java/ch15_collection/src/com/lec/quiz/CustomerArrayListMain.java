package com.lec.quiz;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
// N�� �Է��� ������ �� �̸�, ��ȭ, �ּҸ� �Է¹޾� arraylist add
// N�� �Է��ϸ� arraylist for���� �����. arraylist.size(); == 0 �̶�� ��� ����
import java.util.Scanner;

public class CustomerArrayListMain {
	public static void main(String[] args) {
		String name, tel, address;
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("ȸ�� ������ �����ϰڽ��ϱ�? (Y/N) - N �Է½� ȸ�� ����Ʈ�� ����մϴ�.  : ");
			String answer = scanner.nextLine().trim();
			if (answer.equalsIgnoreCase("n") && customers.size()!=0) {
				break;
			}else if(answer.equalsIgnoreCase("n") && customers.size()==0) {
				System.out.println("���� �ѹ� �̶� �� �ϸ� �� ����");
			}

			System.out.println("����� �̸��� �Է����ּ���. : ");
			name = scanner.nextLine();
			System.out.println("����� ��ȭ��ȣ�� �Է����ּ���. : ");
			tel = scanner.nextLine();
			System.out.println("����� �ּҸ� �Է����ּ��� : ");
			address = scanner.nextLine();
			customers.add(new Customer(name, tel, address)); // Customer ��ü�� ������ �ϹǷ�, new customer() �� ����� ������.

		}
		if (customers.size() == 0) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			for (Customer customer : customers) {
				System.out.println(customer);
			} // for
		} // if
	}
}
