package com.lec.condition;

// ���� �Ҵ� �� ������ ���� ����� ���
public class Ex01_if {
	public static void main(String[] args) {
		int score = 35;
		if (score >= 90) {
			System.out.println("�Ϻ��մϴ�");
		} else if (score >= 70){ // 70~ 89������
			System.out.println("�� �Ϻ� ���ϳ�"); // if�� else�� �� ��ȣ�� �ϳ��� �־��ٰ�
		} else if (score >= 60) { // 60 ~ 69������
			System.out.println("�� �� �й��Ͻô���");
		} else {
			System.out.println("������Դϴ�.");
		}
		System.out.println("DONE");

	}
}
