package com.lec.condition;

// ���� ������ ���� ��� 
public class Ex04_switch_hakjum_random {
	public static void main(String[] args) {
		// ���� �߻�
		// System.out.println((int)(Math.random() * 101)); // (0���� 1������ �Ǽ�(�Ҽ�)�� ������ ǥ�� >0, <=1) * 101�ϸ� 0�̻� 101 �̸��� ���� �߻� (100�� �����ؾ� �ϹǷ� 101 ���ϴµ�)
		 // (int)(Math.random() * 101 �ϴ� ��� �� math.random�� ���� ���� ó�� (0) �ǹǷ� x101�� �ص� 0�� ��. ���� (int)�� �� �տ� �Ѱ�.
		int score = (int)(Math.random() * 101); // int score = (int)(Math.random() * 101);
		System.out.println("���� : " + score);
		// ���� ���
		switch (score / 10) { 
		case 10: case 9:
			System.out.println("A����"); break;
		case 8:
			System.out.println("B����"); break;
		case 7:
			System.out.println("C����"); break;
		case 6:
			System.out.println("D����"); break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("F����"); break; // ��ǻ�ʹ� ���� �� �����Ƿ� 101�̳� ��Ÿ ���� �Է����� �����Ƿ� default�� �ʿ����� ����		
		}
		
		/*
		 * if ((score >= 90) && (score < 100)) { // 2���� ����. ��ȣ�� �켱���� ��������. (���ص� �Ǳ���)
		 * System.out.println("A����"); } else if (score >= 80 && score < 90) { // 100����
		 * ������ �� ��� ������. score < 90�� �־���� System.out.println("B����"); } else if (score >=
		 * 70 && score < 80) { System.out.println("C����"); } else if (score >= 60 &&
		 * score < 70) { System.out.println("D����"); } else if (score >= 0 && score < 60)
		 * { System.out.println("F����"); } else { System.out.println("��ȿ���� ���� ����");
		 * 
		 * } // else
		 */
		
	} //main
} // class
