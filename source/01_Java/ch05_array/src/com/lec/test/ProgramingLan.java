package com.lec.test;

public class ProgramingLan {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 93 };
		int total = 0;
		// �հ�, ���, �ִ�, �ּ�
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.print("��      �� = " + total + "\t");
		System.out.printf("��    �� = %.2f\n", ((double) total / arr.length));
		int temp = 0;
		int temp2 = 200;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > temp) {
				temp = arr[i];
			}

		}
		System.out.print("�ִ밪��  = " + temp + "\t");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < temp2) {
				temp2 = arr[i];
			}
		}
		System.out.println("�ּҰ��� = " + temp2 + "\n");
	}
}
