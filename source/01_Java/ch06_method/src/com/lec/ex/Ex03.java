package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) { //public = �ܺο��� ���డ���� �޼ҵ��� �ǹ�
		// ���� �����ϸ�? default �� �Ǹ鼭 �ٸ� ��Ű������ ����� �� ���Ե�.
		System.out.println("-9�� ���밪��" + Arithmetic.abs(-9)); // �ڵ��ϼ� ���� import�� �ڵ����� ����.
		// ��Ű���� �ٸ���� Arithme���� �Է��� �� ��Ʈ�� �����̽��� import�� �� ����.
		// static�� ��� absó�� ������Ʈ, static�� �ƴϸ� evenOdd, sumó�� �Ϲݱ��ڷ� ���
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(10);
		System.out.println("1���� 10������ ���� " + tot);
		System.out.println(ar.evenOdd(tot));
		tot = ar.sum (10,100);
		System.out.println("10���� 100������ ����" + tot);
		System.out.println(ar.evenOdd(tot));
}
}