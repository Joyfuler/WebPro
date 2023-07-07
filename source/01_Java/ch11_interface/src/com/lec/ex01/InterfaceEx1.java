package com.lec.ex01;
// 인터페이스 - 추상메소드와 상수만 들어갈 수 있음. (final double PI=3.14~)
public interface InterfaceEx1 {
	public int CONSTANT_NUM = 10;
	public abstract void method1(); // abstract 생략 가능
	// 매개변수와 리턴타입이 없는 method1을 짜라는 작업명세서 역할. 이후 클래스에서 오버라이드하여 해결
}
