package com.lec.ex;
// ���� ���� ���. �⺻ : int i =10;
public class VarEx03 {
	
	public static void main(String[] args) {
		// 1. �ڷ��� ������ = �ʱⰪ; - ���� ����� ���ÿ� �ʱ�ȭ(�Ҵ�)
		int num1 = 10;
		// 2. �ڷ��� ������; ���� ���� �ʰ� ������ ������ ��. but ����ÿ��� ������ �߻�
//		int num2;
		int num2 = 20; // �Ҵ��� ���
		System.out.printf("num1=%d \t num2=%d \n", num1, num2);
		
		// 3. �ڷ��� ����1 = ��1, ����2=��2 , ����3=��3 ..; �����ڷ��� ������ �ټ� ����� �ʱ�ȭ
		int num3=30, num4=40, num5=50; //���� ������ �ѹ��� ����� �ʱ�ȭ
		System.out.printf("num3=%d \t num4=%d \t num5=%d \n", num3, num4, num5);
		
		// 4. �ڷ��� ����1, ����2, ..; �����ڷ��� ������ �ټ� ���� (�ʱ�ȭx)
		int num6, num7, num8;
		num6 = 50; num7= 60;
		System.out.printf("num6=%d \t num7=%d \n", num6, num7);
	}

}
