package com.lec.ex;
// 1���� 10���� ������ �հ� �� ����� ¦������ Ȧ������ ����ϴ� ��.
public class Ex01 {
	public static void main(String[] args) {
		int num =0; 
		for(int i=1; i<=10; i++) {
		num += i;	
		} System.out.println("������ " + num);
		System.out.println( num % 2 == 0 ? "¦���Դϴ�." : "Ȧ���Դϴ�.");
		
		
		num =0; 
		for(int i=11; i<=100; i++) {
		num += i;	}
		System.out.println("������ " + num); // ��ġ�� ���� ��������� ����� �з��� �ι��ľ���. �޸�����...
		
	}
}
