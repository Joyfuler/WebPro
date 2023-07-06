package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		SuperClass obj = new ChildClass(); // 추상 클래스 (SuperClass)는 타입으로만 가능 . 객체 생성은 불가
		obj.method1();
		obj.method2(); // 변수.메소드 수행시 본래는 타입에 맞는 것을 수행. but 실제 실행은 일반메소드만 실행. 추상클래스 superclass의 method1이 호출되지 않음.
		obj.method3();
		
		// obj.method4(); 실행하는 시점에는 childclass에 method4가 있지만... superclass타입이므로 컴파일 에러가 남.
		// 즉 실행하는 시점이 아니라 기계어 컴파일 과정에서 문법 오류가 있으면 에러가 발생.
	if (obj instanceof ChildClass) { // 있다면 형변환해서 실행할 것.
		((ChildClass)obj).method4(); // 형변환: (차일드클래스의) obj 객체로 바꾸고, 그 중 method4를 실행하라.
	}
	if (obj instanceof SuperClass) {
		
	}
	
	}
	}

