package com.lec.ex03;

import com.lec.ex02.SuperClass;

// superclass(�߻�޼ҵ������� �߻�Ŭ����) : method1,2,3 // 
// ChildAbstractClass (�߻��� �������̵�x, �������� ��� ���� �߻�Ŭ����) : method1,2,3,4 //
// GrandChild(�Ϲ�Ŭ����), �������̵�Ϸ� ��  : method 1,2,3,4


public class TestMain {
	public static void main(String[] args) {
		SuperClass obj1 = new GrandChild(); // grandchild�� method1,2,3,4�� ȣ��
		obj1.method1();
		obj1.method2();
		obj1.method3();
		// obj1.method4(); //  ����?! --> ����ȯ �ʿ�. Superclass���� method4�� ����...
		
		ChildAbstractClass obj2 = new GrandChild();
		obj2.method1();
		obj2.method2();
		obj2.method3();
		obj2.method4(); // obj2�� ��� ����. childabstractclass���� �޼ҵ�4�� ���� �������̵� �߱� ����.
	}
}


