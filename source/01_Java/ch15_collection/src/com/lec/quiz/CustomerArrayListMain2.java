package com.lec.quiz;

import java.util.ArrayList;
// N�� �Է��� ������ �� �̸�, ��ȭ, �ּҸ� �Է¹޾� arraylist add
// N�� �Է��ϸ� arraylist for���� �����. arraylist.size(); == 0 �̶�� ��� ����
import java.util.Scanner;

public class CustomerArrayListMain2 {
	public static void main(String[] args) {
		String name, tel, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("ȸ�� ������ �����ϰڽ��ϱ�? (Y/N) - N �Է½� ȸ�� ����Ʈ�� ����մϴ�.  : ");
			String answer = scanner.nextLine().trim();
			if (answer.equalsIgnoreCase("n") && customers.size()!=0) {
				break;
			}else if(answer.equalsIgnoreCase("n") && customers.size()==0) {
				System.out.println("���� �ѹ� �̶� �� �ϸ� �� ����");
			}

		Customer customer = new Customer(); // customer.name = null tel= null address = null. �Ű����� x
		System.out.println("����� �̸���?");
		customer.setName(scanner.nextLine()); // name�̶�� ���� ���� ���� �̸��� �ٷ� �Ű������� set��.
		System.out.println("����� �̸���?");
		customer.setTel(scanner.nextLine()); // name�̶�� ���� ���� ���� �̸��� �ٷ� �Ű������� set��.
		System.out.println("����� �ּҴ�?");
		customer.setAddress(scanner.nextLine()); 
		customers.add(customer); // �� ���� customers��� �迭�� �ϳ��� �߰�
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
