package com.lec.ex02;

public class SuperClassMain {
	public static void main(String[] args) {
		SuperClass obj = new SuperClass() { // �޼ҵ�1�� ������ ������ִ� �͸�Ŭ���� (�ڵ��ϼ�)
			
			@Override
			public void method1() {
				System.out.println("�͸�Ŭ������ method1");
			}
		};
			obj.method1();	
			obj.method2();
			obj.method3(); // ��¥ �߻�Ŭ����x, �͸��� Ŭ������� ���� ���� ���� ��.
		
	}
	}
