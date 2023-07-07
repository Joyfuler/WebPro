package com.lec.ex01;
// CONSTANT_NUM, method1(추상) . 메소드1,2는 반드시 오버라이드
public class ClassEx implements InterfaceEx1, InterfaceEx2 {

	@Override
	public void method1() {
		System.out.println("실제 구현은 implements한 이 클래스에서 함. - method1을 출력");
	} // 인터페이스1을 구현받음

	@Override
	public void method2() {
		System.out.println("실제 구현은 implements한 이 클래스에서 함. - method2를 출력");
			
	}
}
