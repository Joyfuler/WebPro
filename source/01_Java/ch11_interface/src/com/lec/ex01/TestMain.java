package com.lec.ex01;
//�������̽�1 : NUM���, �޼ҵ�1
//�������̽�2: STRING���, �޼ҵ�2
public class TestMain {
	public static void main(String[] args) {
		// InterfaceEx1 ex1 = new InterfaceEx1(); �Ұ�
	ClassEx obj = new ClassEx();
	obj.method1();
	obj.method2();
	InterfaceEx1 obj1 = new ClassEx();
	obj.method1();
	// obj.method2();  // ����ȯ�� ���شٸ� ����������...
	
	InterfaceEx2 obj2 = new ClassEx();
	obj2.method2();
	// obj2.method1(); // �ش� Ŭ������ ������ ������, �������̽�Ex2���� �޼ҵ�1�� �����Ƿ� ����..
	System.out.println("CONSTANT_NUM : " + InterfaceEx1.CONSTANT_NUM); // ������ �ִ� ����� �״�� �ᵵ �ǰ�,
	System.out.println("CONSTANT_NUM : " + ClassEx.CONSTANT_NUM); // ��ӹ��� classEX���� �ᵵ ��.
	System.out.println(("CONSTANT_NUM : " + obj.CONSTANT_NUM)); // ��, static�̶�� ��ü���� class�� �����ϴ� ���� ��õ.
	System.out.println("CONSTANT_STRING : " + ClassEx.CONSTANT_STRING);
	System.out.println("CONSTANT_STRING : " + InterfaceEx2.CONSTANT_STRING); 
	
	}
}
