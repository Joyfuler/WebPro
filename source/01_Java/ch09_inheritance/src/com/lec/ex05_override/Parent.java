package com.lec.ex05_override;
// �����ε��� �Ű������� ���� ���� �̸��� �Լ� �� �´� ���� ã�ư� �޸� ����Ǵ� ��. (�Լ� �ߺ�����)

// �������̵���? 

public class Parent {
	public Parent() { // 2�� ������ ����. ���� �̸��̹Ƿ� �����ε�(�Լ� �ߺ�����)
		System.out.println("�Ű������� ���� Parent ������");
	}

	public Parent(int i) {
		System.out.println("�Ű����� i=" +i +"�� �ִ� Parent ������");
	}
	
	public void method1() {
		System.out.println("Parent�� method1() �Լ�");
	}
	public void method2() {
		System.out.println("Parent�� method2() �Լ�");
	}

}
