package com.lec.ex4_object;

public class Ex3_CardMain {
	public static void main(String[] args) {
		Card c1 = new Card("��", 3);
		Card c2 = new Card("��", 3);
		Card c3 = null;
		String s = "ȫ��";
		
		System.out.println(c1);
		System.out.println(c2);
		//toSting �������̵�� � �����Ͱ� ������ Ȯ���ϴ� �뵵�ε� ���� ����ϰ� ��. �׻� ����ϵ���..
		int i=10, j=10;
		System.out.println("i�� j�� ����? " + (i==j)); 
		// int ���� �� �ҹ��� Ÿ���� ���� ==�� ��밡��. �׷��� String �� �빮�� Ÿ���̶�� equals�� ����ؾ� ��.
		System.out.println("c1�� c2�� ���� �ּҳ�? " + (c1==c2)); // x, ���� �ٸ� ��ü�̹Ƿ� �翬�� false. �ּҸ� ���ϴ� ��
		System.out.println("c1�� c2�� ���� 'ī��(�����Ͱ�)'��? " + (c1.equals(c2))); // �׳� �����ϸ� �ٽ� �ּҸ� ����. ���� equals�� �������̵��������.
		System.out.println("c1�̶�� c3�� ������?" + (c1.equals(c3))); // c3 �� null�̹Ƿ� �� ��ü�� �ٸ�.	return false;
	}
}
