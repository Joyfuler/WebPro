package com.lec.ex05_override;

public class Child extends Parent {

	public Child () {
		System.out.println("매개변수가 없는 Child 생성자 함수");
	}
	public Child (int i) {
		System.out.println("매개변수 i가 있는 Child 생성자 함수");
	}
	@Override
	public void method1() { // override = 함수 재정의. Superclass가 아니라 이곳에서 다시 사용할 예정.
		System.out.println("Child의 method1 함수");
	} 
	public void method3(){
		System.out.println("Child의 method3 함수");
	}
	@Override // object에 있는 equals 라는 함수도 재정의가 가능함.
	public boolean equals(Object obj) {
			return true;
	}
	
	
}
