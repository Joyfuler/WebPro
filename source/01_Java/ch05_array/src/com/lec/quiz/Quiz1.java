package com.lec.quiz;

public class Quiz1 {
	public static void main(String[] args) {
		// 76 45 34 89 100 50 90 92
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		for (int i = 0; i < arr.length - 1; i++) { // ū���� �ڸ��� �ڸ��� �ٲܶ� �ӽú����� �־���
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) { // �տ��� �޿����� ũ��
					int temp = arr[i]; // temp ������ �տ����� �ӽ÷� ��ġ��
					arr[i] = arr[j]; // �۾Ҵ� �޿����� �տ���
					arr[j] = temp; // �Ǵ� ���� �ڷΰ�. // �� ���� ������ ���� ū���� ���ٴ� ��.

				}

			}
			System.out.print(arr[i] + " ");
		}
		// ū������ ���� ���� ���� �Ƿ���?
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) { // �տ��� �޿����� ������?
					int temp = arr[i]; // temp ������ �տ����� �ӽ÷� ��ġ��.
					arr[i] = arr[j]; // �Ǵ� �޿����� �տ���
					arr[j] = temp; // �۾Ҵ� ���� �ڷΰ�.

				}
			}
			System.out.print(arr[i] + " "); // ū������ �������� ����.
		}

		// 0��° �迭 i�� 1,2,3�� j�� ���� �� 1��° �迭 i�� 2,3�� j�� ��..
		// i=j ������ �����ϸ� ���� ���� ��. �ӽ� ������ ����� ���������..

	}
}
