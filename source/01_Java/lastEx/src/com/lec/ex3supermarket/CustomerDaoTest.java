package com.lec.ex3supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> customers;
		System.out.println("1�� ȸ�������׽�Ʈ");
		String ctel = "010-3535-5555";
		String cname = "���浿";
		result = dao.insertCustomer(ctel, cname); // ����or�����̹Ƿ�
		System.out.println(result == CustomerDao.SUCCESS ? cname + "�� ȸ�����԰���. ����Ʈ 1000�� �ο�" : cname + "�� ���Խ���");

		System.out.println("2�� ��ȭ��ȣ�˻��׽�Ʈ");
		ctel = "010-9999-9999";
		customers = dao.ctelGetCustomers(ctel);
		if (customers.isEmpty()) {
			System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �ش��ϴ� ȸ���� �����ϴ�.");
		} else {
			System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ���\t������\t����������ġ");
			for (CustomerDto customerDto : customers) {
				System.out.println(customerDto);
			}
			System.out.println("�� �ο����� " + customers.size() + "��");
		}

		System.out.println("3�� ���ǻ���׽�Ʈ");
		int cid = 4;
		if (dao.getCustomer(cid) == null) { // �ش�ȸ���� �־�߸� ��ǰ���Ű���
			System.out.println(cid +"�� �ش��ϴ� ȸ���� ���� ���Ÿ� ������ �� �����ϴ�.");
		} else {
			int price = 500000;
			result = dao.buy(cid, price);
			if (result == CustomerDao.SUCCESS) {
				System.out.println("��ǰ���ż���. ������ ������ �Ʒ��� ���� ������Ʈ�Ǿ����ϴ�.");
				System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ���\t������\t����������ġ");
				System.out.println(dao.getCustomer(cid));								
			} else {
				System.out.println("��ǰ���Ž���");
			}
		}
		
		System.out.println("4�� ���������");
		customers = dao.levelNameGetCustomers("VVIP");
		if (customers.size() ==0) {
			System.out.println("�ش緹���� ȸ���� �����ϴ�.");			
		} else {
			System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ���\t������\t����������ġ");
			for (CustomerDto customerDto : customers) {
				System.out.println(customerDto);				
			}
		}
		
		System.out.println("5�� ��ü���");
		customers = dao.Getcustomers();
		if (customers.size() ==0) {
			System.out.println("�ش緹���� ȸ���� �����ϴ�.");			
		} else {
			System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ���\t������\t����������ġ");
			for (CustomerDto customerDto : customers) {
				System.out.println(customerDto);
			}
		}
		
		System.out.println("6�� ȸ��Ż��");
		result = dao.deleteCustomer("010-9999-9999");
		System.out.println(result == CustomerDao.SUCCESS? "��������": "��ȿ�� ��ȣ�� �ƴմϴ�.");
		
	}
}