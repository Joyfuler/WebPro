package com.lec.loop;
// break�� continue ���
public class Ex05_break_continue {
	public static void main(String[] args) {
		for (int i= 1; i <= 10; i++) {
			if (i ==3) {
				continue; // i�� 3�� �Ǿ��� �� �� ���� �ö�. (�������� �ִ� ������) --> ��� 3�� �Ǵ� ���� 3�� ��µ��� �ʰ� ���ǽ����� ���ư� 4���� �ٽ� ��µ�
				// break; // i�� 3�� �Ǹ鼭 break�Ǿ� �ݺ����� ��������. ��� 1�� 2�� ��µǰ� ��ȣ������ ����
			}
			System.out.println(i);
		}
		System.out.println();
	} 
}
