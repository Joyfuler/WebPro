package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		int kr = 98; // �������� 98��
		double eng = 89.9; // �������� 89.9��
		int math = 56; // �������� 56��
		double total = kr + eng + math; // ����
		double average = (double) total / 3.0; // �Ҽ��� �����Ƿ� �Ҽ������� ������ ���� �̻���..
		System.out.println("���� :" + kr + "\n���� :" + eng + "\n���� :" + math);
		System.out.printf("����: %.1f \n���: %.1f\n", total, average);
		System.out.printf("�� ���� ���� ������ �� ���� = %.1f �Դϴ�. \n", total);
		System.out.printf("�� ���� ���� ������ ��� ���� = %.1f �Դϴ�.", average);

	}
}
