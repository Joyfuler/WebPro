package com.lec.ex05_test;

public class TestMain {
	public static void main(String[] args) {
		TestChildClass obj = new TestChildClass();
		System.out.println(I3.i1); // i1은 여러 군데에 구현되어 있으므로 i1, i3, testclass, testchildclass 모두 가능.
		System.out.println(TestChildClass.i1); // 단, static 변수는 class 이름으로 접근하는 것을 추천.
		System.out.println(TestClass.i1);
		obj.m2();
		obj.m3();
		obj.m11(); // 메소드는 객체 이름으로 접근.
		TestClass obj1 = obj;
		obj1.m1();
		obj1.m2();
		obj1.m3();
		((TestChildClass) obj1).m11();

	}
}
