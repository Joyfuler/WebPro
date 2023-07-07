package com.lec.ex05_test;
// i1, i2, i3, m1(), m2(), m3(), // i11과 m11(오버라이드x) 
public class TestChildClass extends TestClass implements I3, I11{ // extends가 항상 앞에 오도록 할 것. 정해진 순서.

	@Override
	public void m11() {
		System.out.println("i11 = " + i11); // 오버라이드되지 않았던 m11을 마저수행
		
	}

}
