package com.lec.ex05_override;
// 오버로딩은 매개변수에 따라 같은 이름의 함수 중 맞는 곳에 찾아가 달리 실행되는 것. (함수 중복정의)

// 오버라이딩은? 

public class Parent {
	public Parent() { // 2개 생성자 만듬. 같은 이름이므로 오버로딩(함수 중복정의)
		System.out.println("매개변수가 없는 Parent 생성자");
	}

	public Parent(int i) {
		System.out.println("매개변수 i=" +i +"가 있는 Parent 생성자");
	}
	
	public void method1() {
		System.out.println("Parent의 method1() 함수");
	}
	public void method2() {
		System.out.println("Parent의 method2() 함수");
	}

}
