package com.lec.loop;

// 1 ~ 10���� �������� 55�Դϴ�.
// 1+2+3+4+5+6+7+8+9+10 = 55
public class Ex02for {
	public static void main(String[] args) {
		int total = 0;
		for(int i = 1; i <= 10; i++) {
			total += i; //total = total + i;
			// �������� �ִ� �ٷ� �Ʒ��� ���� �־��ش�.
			// System.out.print(i + "+");
			// �������� 10+�� �ٲ�����. �� �����ؾ�...
			System.out.print(i);
			if (i != 10) {
				System.out.print("+"); // i�� 10�� �Ǵ� ���� ���x
			}
			
		}
		System.out.println(" = " + total);
		// 1+2+3+4+5+6+7+8+9+10= �������� ����Ϸ���?
		System.out.println();
	}
}
