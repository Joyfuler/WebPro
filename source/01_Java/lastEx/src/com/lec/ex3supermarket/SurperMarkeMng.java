package com.lec.ex3supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SurperMarkeMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn; // ���� �Է��ϴ� ��
		ArrayList<CustomerDto> customers; // �ش� Ŭ������ ���� �迭��ü���� ��ȯ����

		do {
			System.out.println("1:ȸ������ 2:���˻� 3:��ǰ���� 4:��������� 5:��ü��� 6:ȸ��Ż�� ��Ÿ:����");
			fn = scanner.next();
			switch (fn) {
			case "1":
				System.out.print("������ ȸ�� �ڵ�����ȣ��?");
				String ctel = scanner.next();
				System.out.print("������ ȸ���̸���?");
				String cname = scanner.next();
				int result = dao.insertCustomer(ctel, cname);
				System.out.println(result == CustomerDao.SUCCESS ? "���Լ���" : "���Խ���");
				break;

			case "2":
				System.out.println("�˻��� ��ȭ��ȣ 4�ڸ�, or ��ȭ��ȣ ��ü �Է����ּ���");
				String searchTel = scanner.next();
				customers = dao.ctelGetCustomers(searchTel);
				if (customers.isEmpty()) {
					System.out.println("�ش��ϴ� ��ȭ��ȣ ȸ���� �����ϴ�.");
				} else {
					System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ���\t������\t����������ġ");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
					System.out.println("�ش��ϴ� ȸ���� :" + customers.size() + "��");
				}

				break;
			case "3":
				System.out.print("������ ��id�� �Է��ϼ���. (���̵� �߸��Էµɰ�챸�źҰ�)");
				int cid = scanner.nextInt();
				if (dao.getCustomer(cid) == null) {
					System.out.println("�ش� id�� ���� �����ϴ�.");
				} else {
					System.out.print("���űݾ���? ");
					int price = scanner.nextInt();
					result = dao.buy(cid, price);
					if (result == CustomerDao.SUCCESS) {
						System.out.println("��ǰ���� �����մϴ�." + price + "�� ���� �� ���� ������ ������Ʈ �Ǿ����ϴ�.");
						System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ���\t������\t����������ġ");
						System.out.println(dao.getCustomer(cid));
					}
				}
				break;
			case "4":
				System.out.print("�˻��ϰ��� �ϴ� ��޸���?" + dao.getLevelNames());
				String levelName = scanner.next();
				customers = dao.levelNameGetCustomers(levelName);
				if (customers.isEmpty()) {
					System.out.println("�ش����� ���� �����ϴ�.");
				} else {
					System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ���\t������\t����������ġ");
					for (CustomerDto customerDto : customers) {
						System.out.println(customerDto);
					}
				}
				break;
			case "5":
				customers = dao.Getcustomers();
				if (customers.isEmpty()) {
					System.out.println("�ش����� ���� �����ϴ�.");
				} else {
					System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ���\t������\t����������ġ");
					for (CustomerDto customerDto : customers) {
						System.out.println(customerDto);
					}
				}
				

				break;
			case "6":
				System.out.println("Ż���� ��ȭ��ȣ��?");
				ctel = scanner.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDao.SUCCESS? "��������" :"��������");

				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4") || fn.equals("5")
				|| fn.equals("6"));
		System.out.println("����");
	}

}
