package com.lec.quiz;

public class ProgramingLan2 {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 93 };
		int total = 0;
		// �հ�, ���, �ִ�, �ּ�
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println("�迭�� ��� ���� ���� " + total + "�̰�, ");
		System.out.printf("����� %.2f �̸�, ", ((double) total / arr.length));
		int temp = 0;
		int temp2 = 200;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > temp) {
				temp = arr[i];
			}

		}
		System.out.println("�ִ밪�� " + temp + "�Դϴ�.");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < temp2) {
				temp2 = arr[i];
			}
		}
		System.out.println("�ּҰ��� " + temp2 + "�Դϴ�.");
	}
}
