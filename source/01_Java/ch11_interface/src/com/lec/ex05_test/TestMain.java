package com.lec.ex05_test;

public class TestMain {
	public static void main(String[] args) {
		TestChildClass obj = new TestChildClass();
		System.out.println(I3.i1); // i1�� ���� ������ �����Ǿ� �����Ƿ� i1, i3, testclass, testchildclass ��� ����.
		System.out.println(TestChildClass.i1); // ��, static ������ class �̸����� �����ϴ� ���� ��õ.
		System.out.println(TestClass.i1);
		obj.m2();
		obj.m3();
		obj.m11(); // �޼ҵ�� ��ü �̸����� ����.
		TestClass obj1 = obj;
		obj1.m1();
		obj1.m2();
		obj1.m3();
		((TestChildClass) obj1).m11();

	}
}
