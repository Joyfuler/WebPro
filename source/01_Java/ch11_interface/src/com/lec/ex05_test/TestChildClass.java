package com.lec.ex05_test;
// i1, i2, i3, m1(), m2(), m3(), // i11�� m11(�������̵�x) 
public class TestChildClass extends TestClass implements I3, I11{ // extends�� �׻� �տ� ������ �� ��. ������ ����.

	@Override
	public void m11() {
		System.out.println("i11 = " + i11); // �������̵���� �ʾҴ� m11�� ��������
		
	}

}
