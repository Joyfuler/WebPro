package com.lec.quiz;

public class PracMain {

	public static void main(String[] args) {
		Prac a1 = new Prac("aaa", "ȫ�浿", "hong@company.com", "���� ������", "2000-01-01", '��');

		System.out.println("id : " + a1.getId());
		System.out.println("�̸� : " + a1.getName());
		System.out.println("�̸���: " + a1.getEmail());
		System.out.println("�ּ� : " + a1.getAddress());
		System.out.println("������� : " + a1.getBirthday());
		System.out.println("���� : " + a1.getGender());

		System.out.println("-------------------���� �迭---------------");

		Prac[] a2 = { new Prac("aaa", "ȫ�浿", "hong@company.com", "���� ������", "2000-01-01", '��'),
				new Prac("bbb", "�ű浿", "shin@company.com", "���� ������", "2000-11-01", '��') };

		for (int idx = 0; idx < a2.length; idx++) {
			System.out.println("id : " + a2[idx].getId());
			System.out.println("�̸� : " + a2[idx].getName());
			System.out.println("�̸���: " + a2[idx].getEmail());
			System.out.println("�ּ� : " + a2[idx].getAddress());
			System.out.println("������� : " + a2[idx].getBirthday());
			System.out.println("���� : " + a2[idx].getGender());
			System.out.println("----------------------------");

		}

	}
}
