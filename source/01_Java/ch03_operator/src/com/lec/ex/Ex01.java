package com.lec.ex;
// ��� ������: + - * / (������, �������� ������ �� ������: 3������ 2�� 1) %
public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result; double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		// ���� ���ϱ� ���� = ���ڸ� ǥ���ϰ� ���� ��. �� ������ ǥ���� �� �� �ش� ������ ���� ����.
		// sysout.printf("%d %c %d = %d\n", n1, '-', n2, result);
		
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
		// �� ��� ������ ������ �����⿡ �� ���� �� ����. 3.3 (x) --> 3
		resultDouble = (double) n1 / n2;
		System.out.printf("%d %c %d = %.1f\n", n1, '/', n2, resultDouble); // .1f�� 1�ڸ� �Ҽ�������
		
		result =n1 % n2; // n1�� n2�� ���� ������
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result); // 33�� 10���� ���� ������ = 3
		// ������ �������� �뵵 : ¦��/Ȧ�� �Ǻ�, ��� �Ǻ��뵵 ex �������� 2�� ����� ����...
		if (n1%2 == 0) {
			System.out.println("n1�� ¦���Դϴ�.");
		} else {
				System.out.println("n1�� Ȧ���Դϴ�.");
				
			}
		
		if (n1%5 ==	0) { // �������� 0�� �� if (����) {���϶� ������}; else {�����϶� ������};
			System.out.println("n1�� 5�� ����Դϴ�.");
		} else {
			System.out.println("n1�� 5�� ����� �ƴմϴ�.");
		}
		}
	
		
	}
