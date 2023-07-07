package com.lec.ex05_test;
// i1, m1() 추상, i2, m2() 추상


public interface I3 extends I1, I2 { // 인터페이스로부터 인터페이스는 상속으로. implements(x)
	public int i3 = 3;
	public void m3();
}
