package com.lec.ex02;

public class ChildClass extends SuperClass {

	@Override
	public void method1() { // 추상클래스는 자동적으로 오버라이드되면서 에러발생. . 수정하라는 의미
		System.out.println("ChildClass의 method1");
		// 반면 method2와 method3은 오버라이드를 해도 되고 안해도 됨. (선택)
		}
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2");

	}
	public void method4() {
		System.out.println("ChildClass의 method4");
	}

	}


