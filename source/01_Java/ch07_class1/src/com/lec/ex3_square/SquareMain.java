package com.lec.ex3_square;

public class SquareMain {
	public static void main(String[] args) {
		// s1.setSide // getSide
	
		Square s1 = new Square(); // �Ű������� ���� ������ �Լ� ȣ�� --> �⺻ �������̱� ����.
		System.out.println("s1�� �� �� ���̴� " + s1.getSide()); // 0���� �ʱ�ȭ�Ǿ� �����Ƿ� 0�� ����.
		System.out.println("s1�� ���̴�" + s1.area());
		
		
		Square s2 = new Square(10); // side�� 10���� �ʱ�ȭ�� s2 ������ ȣ��. --> side �Ű������� �� Square �޼ҵ带 �ҷ���.
		System.out.println("s2�� �� �� ���̴� " + s2.getSide());
		System.out.println("s2�� ���̴� " + s2.area());
		
		
		s1.setSide(5);
		System.out.println("���� ���� side ���� " + s1.getSide());
		System.out.println("5�� ���̸� ���� ���簢���� ����: " + s1.area());
		
		
	} 
}
