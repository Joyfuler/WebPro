package com.lec.method;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(" -9�� ���밪�� : " + Arithmetic.abs(-9)); 
		//class�� �ٸ� ��� �տ� Ŭ���� �̸��� �� �� �޼ҵ带 ���ָ� �۵���.
		// abs �տ��� static�� ��������Ƿ� �ٸ� Ŭ�������� ������.
		
		
		
		// ���� string�� ���� ���� ���� sum�̳� ovenOdd�� ���?
		// ������ - System.out.println("1���� 10�� ����" + Arithmetic.sum(1,10));
		Arithmetic ar = new Arithmetic(); // �ٸ� Ŭ����(����)���� �ҷ����� ��ü�� ������ ar�� ����. �ٸ� ��Ű���̹Ƿ� 
		int num = ar.sum(11,100);
		System.out.println("11���� 100���� ��������" + num);
		System.out.println(ar.evenOdd(num));
		
		num = ar.sum(50);
		System.out.println("50������ �������� " + num);
		
	}
}
