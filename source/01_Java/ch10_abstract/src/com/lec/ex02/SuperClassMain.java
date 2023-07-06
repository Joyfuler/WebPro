package com.lec.ex02;

public class SuperClassMain {
	public static void main(String[] args) {
		SuperClass obj = new SuperClass() { // 메소드1을 새로이 만들어주는 익명클래스 (자동완성)
			
			@Override
			public void method1() {
				System.out.println("익명클래스의 method1");
			}
		};
			obj.method1();	
			obj.method2();
			obj.method3(); // 진짜 추상클래스x, 익명의 클래스라는 것을 새로 만든 것.
		
	}
	}
