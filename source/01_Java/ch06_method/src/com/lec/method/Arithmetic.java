package com.lec.method;
// sum(from, to) �ܿ� sum(int 1��) �� �Լ� 1���� �ִ� ��� : �Լ��� �����ε� // evenOdd(int 1��) // abs(-9) --> 9�� ��µǴ� ���� ����
public class Arithmetic {
	public int sum(int from, int to) { // from���� to������ ��
		int total = 0;
		for (int i = from; i<=to; i++) { 
			total += i;
		
		
		} return total;
		
		
}
	public int sum (int to) {
		int total = 0;
		for (int i =1; i<=to; i++) {
			total += i;
		} return total;
	}
	
	public String evenOdd (int value) {
		String result = value % 2 == 0? "¦���Դϴ�." : "Ȧ���Դϴ�.";
		return result;
	}
	
	public static int abs (int value) { // static�� �� �Ͱ� �� �� ���� ���̴�?
		int result = value > 0 ? value : value * (-1); // ���밪
		return result;
	}
		
		
		
	
}
