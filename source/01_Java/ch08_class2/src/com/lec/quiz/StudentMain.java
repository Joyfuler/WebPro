package com.lec.quiz;

public class StudentMain {

	public static void main(String[] args) {

		Student s1 = new Student("���켺", 90, 80, 95);
		Student s2 = new Student("���ϴ�", 100, 80, 95);
		Student s3 = new Student("Ȳ����", 95, 80, 90);
		Student s4 = new Student("������", 95, 90, 99);
		Student s5 = new Student("������", 90, 90, 90);
		// �迭���� ���ڸ� ���� �ʾ����� return�� �� �� �տ� StudentNo�� �������� ���������Ƿ�..
		Student[] students = { s1, s2, s3, s4, s5 };
		String[] title = { "��ȣ\t", "�̸�\t", "����\t", "����\t", "����\t", "����\t", "���" };

		Line();
		System.out.println("\t\t\t\t ����ǥ");
		Line('-');
				
		for (int idx = 0; idx < title.length; idx++) {
			System.out.print(title[idx]);
		}
		System.out.println();

		Line('-');
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].infoString());
		}
		// �� ���� ����� ���� total �迭�� ����.
		int total[] = new int[5];
		for (int i = 0; i < students.length; i++) {
			total[0] += students[i].getKor();
			total[1] += students[i].getEng();
			total[2] += students[i].getMat();
			total[3] += students[i].getTot();
			total[4] += students[i].getAvg();
		}
		Line('-');
		

		// ������ ���� �迭 �����
		System.out.print("\t ����\t");
		for (int i = 0; i < total.length; i++) {
			System.out.print(total[i] + "\t");
		}

		System.out.println();
		System.out.print("\t ���\t");
		for (int tot : total) {
			System.out.print(tot / students.length + "\t");
		} 
		System.out.println();
		Line();

	}

	public static void Line() {
		for (int i = 0; i < 65; i++) {
			System.out.print('��');

		}
		System.out.println();

	}

	public static void Line(char c) {
		for (int i = 0; i < 65; i++) {
			System.out.print('-');

		}
		System.out.println();

	}

}
