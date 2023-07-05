package com.lec.ex08_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("ȫ��", "010-9999-9999", "����", "12-01"); //customer ��ü�� �����ϰ� �ٷ� �����Է�
		System.out.println(customer.infoString()); // ���� ���Ը� �������� ������
		customer.buy(500000); // 50������ġ ����
		customer.buy(710000);
		
		Staff staff = new Staff("ȫ���", "010-8888-8888", "2023-07-04", "����");
		// staff�� customer ��� ������ �ִ� ������ �迭ȭ. �̸�, ���� ��...
		Person [] person = {customer, staff};
		for (int idx = 0; idx<person.length; idx++) { // idx�� �̸��� ��ȭ��ȣ�ۿ� �����Ƿ� ���̴� 2
			System.out.println(person[idx].infoString()); // �ش� �ο��� �̸�, ��ȭ��ȣ ��� ������ �ѹ������
		}
		
		System.out.println("-------------------------");
		for (Person p : person) {
			System.out.println(p.infoString()); // idx�� ���� ���� �߰��� ���𰡸� ����ؾ� �Ѵٸ� �Ϲ�, �׳� ó������ ������ ����� �����ϴٸ� Ȯ��for���� ���
		}
	}
}
