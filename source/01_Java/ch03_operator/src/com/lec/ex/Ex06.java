package com.lec.ex;

// �Ҵ� ������ : =, +=, -=, *=, /=, %= �� ����
public class Ex06 {
	public static void main(String[] args) {
		int n1= 10;
		n1 += 10; // n1 = n1 + 10�� ����. ���� n1�� ���� n1 + 10�� ����  -> 20
		System.out.println("n1 = " + n1);
		// �Ϲ������� 1���� �����ϴ� ��� n1++, ++n1�� ����ϰ�, �������� �����ϴ� ���� n1 += 10 ���� �����.
		n1 *= 2; // n1 = n1 * 2 / 20 * 2 = 40
		System.out.println("n1 =" + n1);
		
		int n2, n3;
		n1 = n2 = n3 = 10; // = �� ��� �ں��� ���. n3=10 -> n2 = 10 -> n1= 10 ����.
		System.out.println(n1 + "\t" + n2 + "\t" + n3);
		
		
	}
}
