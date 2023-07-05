package com.lec.ex04_abc;

public class S {
	protected int s; // S클래스를 상속받는 경우엔 s를 자유이용가능
	public S() {
		System.out.println("--------------");
		System.out.println("매개변수 없는 부모단의 생성자 함수");
	}
	
	public S (int s) {
		System.out.println("매개변수가 있는 부모단의 생성자 함수");
	}

}
