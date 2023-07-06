package com.lec.ex02;
// 추상메소드 method1, 일반메소드 method2와 3
public abstract class SuperClass {
	public abstract void method1 (); // 추상메소드 완성 --> 이건 알아서 완성해라 라는 의미
	public void method2() {
		System.out.println("SuperClass의 method2");
	}
	public void method3() {
		System.out.println("SuperClass의 method3");
	}
}
