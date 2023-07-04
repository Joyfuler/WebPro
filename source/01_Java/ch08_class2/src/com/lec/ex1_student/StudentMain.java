package com.lec.ex1_student;

import java.io.ObjectInputStream.GetField;

public class StudentMain {

	public static void main(String[] args) {
		
		Student s1 = new Student("���켺", 90, 90, 90);
		Student s2 = new Student("���ϴ�", 90, 90, 91);
		Student s3 = new Student("Ȳ����", 80, 80, 80);
		Student s4 = new Student("������", 80, 80, 81);
		Student s5 = new Student("������", 99, 99, 99);
		
		Student[] students = {s1, s2, s3, s4, s5};
		String [] title = {"�̸�","����","����","����","����","���"};
		//int totKor = 0, totEng=0, totMat=0, tottot=0, totAvg=0;
		 // 5���� �迭 �����. ���������� 5���� ���� ����ִ� ��.
		line();
		System.out.println("\t\t\t     �� �� ǥ");
		line('-');
		for (String t : title) {
			System.out.print("\t" + t);
		}
		System.out.println();
		
		
		line('-');
		int[] total = new int[5];
		for (int idx = 0; idx < students.length; idx++) { // students �迭�� ���̸�ŭ
			//System.out.println(students[idx].infoString()); // �Ϲ�for�� �Է½� students[idx]�� �Է��ϸ� �ּҶ�.�ڿ� infostring�� ����.
			students[idx].print(); // print�� sout�� �̹� �����Ƿ� sout�� ���� �ʰ� students[idx].print(); �� ����ϸ� ��.
			total[0] += students[idx].getKor(); // �л� 1~5������ �������� ���� total �迭�� ù��°��. (�ݺ���)
			total[1] += students[idx].getEng(); 
			total[2] += students[idx].getMat();
			total[3] += students[idx].getTot(); // �л� 1~5������ ���� ���� total �迭�� �׹�°��. (�ݺ���)
			total[4] += students[idx].getAvg(); // �ټ����� ����� ��. 
			
			// avg�� double������ �� ���� ����ϸ� �˾Ƽ� 8����Ʈ double������ ��ȯ��.
			// Ȥ�� total[4] = total[4] + (int) students[idx].getAvg();
		
		}
		
		line('-');
		System.out.print("\t����");
		for (int tot : total) {
			System.out.printf("\t%d", tot); // �ټ����� �� ����� ����, ����� ��
		}
		
		System.out.print("\n\t���");
		for (int tot : total) {
			System.out.printf("\t%.2f", (double)tot/students.length); // �� ������ �л� �� (5��)��ŭ ����. �Ҽ��� ������ ��ȯ
																		//���� �л� ��ȣ������ �ݺ��� �Ѹ�
			
		
		// idx 0: ����, idx1: ����, idx2: ����, idx3: ����, idx4: ���
	
			
		} System.out.println();
			
		
		line();
		
		
		}
	
	private static void line (char c) { // c�� line���� �Ѹ���
	System.out.print("\t");
	for (int i = 0; i<50; i++) {
		System.out.print(c); // line('-') ���� char c�� �̹� set �����Ƿ�.
	}
	System.out.println();
	}
	

	private static void line() { // �⺻������ - ���ϰ� �� ���� �Ѹ���
		for (int i = 0; i<65; i++) {
			System.out.print('��');
		}
		System.out.println();
		
	}
	}
	

