package com.lec.ex04_abc;
// S의 상속을 받은 A. S는 protected이므로 자유이용 가능
public class A extends S {
	public A() {
		System.out.println("A형 객체 생성 s=1");
		s = 1;
	}

}
