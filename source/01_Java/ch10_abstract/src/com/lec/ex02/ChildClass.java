package com.lec.ex02;

public class ChildClass extends SuperClass {

	@Override
	public void method1() { // �߻�Ŭ������ �ڵ������� �������̵�Ǹ鼭 �����߻�. . �����϶�� �ǹ�
		System.out.println("ChildClass�� method1");
		// �ݸ� method2�� method3�� �������̵带 �ص� �ǰ� ���ص� ��. (����)
		}
	@Override
	public void method2() {
		System.out.println("ChildClass�� method2");

	}
	public void method4() {
		System.out.println("ChildClass�� method4");
	}

	}


