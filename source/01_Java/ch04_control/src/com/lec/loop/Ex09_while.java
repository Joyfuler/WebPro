package com.lec.loop;
// 1~ 10������ ���� �� 3�� ������� ���� ���
public class Ex09_while {
	public static void main(String[] args) {
		// for (int i = 1; i <=10; i++) {
		//	if (i % 3 !=0) {
			//	break;
		int total = 0;
		int i= 1; // �ʱⰪ
		while (i<=10) {
			if (i % 3 == 0) {
				total += i;
			}
			i++;
			
		}
		System.out.println("1���� 10������ 3�� ����� ���� " + total); // sysout�� ��ȣ�ٱ���
		
	}
}
