package com.lec.ex;

// ����������: ++ (1����), --(1����)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; // n1�� 1�����ϰ� n2�� �Ҵ��� ��. (n1�� n2 ��� 11) --> �տ��� ���̸� ��� ���.
		System.out.println("n1 =" + n1 + " n2 =" + n2);
		n2 = n1++; // n2�� n1�� ���Եǰ�, �� �� n1�� +1��. (n2�� 11, n1�� 12)
		System.out.println("n1 =" + n1 + " n2 =" + n2);
		--n1; // n1�� 1 ����. (�տ� �����Ƿ� ��ð��) 
		System.out.println("n1 = " + n1); // (11�� ��.)
		n2 = n1--; // (n1�� �켱 -1 �ǰ�, n2�� �״��. (�տ� n2�� �ֱ� ����)) --> n1�� 10, n2�� 11
		System.out.println("n1=" + n1 + " n2=" + n2);
		
	}
}
