package com.lec.loop;
// 15~ 50����
// 15 16 17 18 19
// 20 21 22 23 24 �϶�, 19�� 24�϶� �����ϵ��� (5�� ������ �������� 4�ΰ�� ����)
public class Ex04_for {
	public static void main(String[] args) {
		for (int i = 15; i < 50; i++) {
			System.out.print(i + "\t");
			if (i % 5 == 4) {
				System.out.println(); // ������ 4�ϋ��� ���ุ �Ѵٴ� �ǹ�
		} // if
		
		} // fori
	} // main
		
	
} //class
