package com.lec.ex4_momchild;

public class ChildTestMain {
	public static void main(String[] args) {
		Child c1 = new Child ("ù° �ʸ���"); // c1�̶�� ��ü�� name(�ʸ���) �� mompouch, takemoney �޼ҵ� ������ ����.
		Child c2 = new Child ("��° �ʼ���"); // c2��� ��ü�� name(�ʼ���) mompouch, takemoney
		Child c3 = new Child ("��° ����"); // c3��� ��ü�� ���� name, mompouch, takemoney
		System.out.println("ù° ���� ���� : " + c1.momPouch.money);
		System.out.println("��° ���� ���� : " + c2.momPouch.money);
		System.out.println("�¤� ���� ���� : " + c3.momPouch.money); // ���� ��� mompouch�� money �����ʹ� 200���� ����.
		
		c1.takeMoney(100); // ù°�� 100���� ���� ���
		System.out.println("���� ���� : " + c1.momPouch.money);
		c2.takeMoney(100); // ��°�� 100���� ���� ���
		System.out.println("���� ���� : " + c2.momPouch.money); // �и� c1���� 100�� ������ 100���� ���Ҿ�� �ߴµ� �� 100���� ����.
		c3.takeMoney(200);
		System.out.println("���� ���� : " + c3.momPouch.money);
		
		// static���� mompouch�� ���� �����ߴٸ� c1.momPouch.money... ������ �Է��� �ʿ� ���� child.mompouch.money �� ǥ���ص� ���� ����� ����.
		
	}
}
