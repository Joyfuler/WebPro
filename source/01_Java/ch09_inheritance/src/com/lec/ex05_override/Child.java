package com.lec.ex05_override;

public class Child extends Parent {

	public Child () {
		System.out.println("�Ű������� ���� Child ������ �Լ�");
	}
	public Child (int i) {
		System.out.println("�Ű����� i�� �ִ� Child ������ �Լ�");
	}
	@Override
	public void method1() { // override = �Լ� ������. Superclass�� �ƴ϶� �̰����� �ٽ� ����� ����.
		System.out.println("Child�� method1 �Լ�");
	} 
	public void method3(){
		System.out.println("Child�� method3 �Լ�");
	}
	@Override // object�� �ִ� equals ��� �Լ��� �����ǰ� ������.
	public boolean equals(Object obj) {
			return true;
	}
	
	
}
