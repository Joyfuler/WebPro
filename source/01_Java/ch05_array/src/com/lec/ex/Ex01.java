package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 20; //���ݱ��� ������� ���� ��Ÿ��
		// i = 30; // i�� 30���� �ٲ�, ���� 20�� ���ư�.
		
		// 1. �迭 ������ ����� �ʱ�ȭ
		int[] iArr = {10, 20, 30, 40, 50}; // ����[] �̸� = {���}... �迭�� �ʱ�ȭ�Ѱ�. 
		// String�� ���������� �ٸ� ���� �ִ� �������� �������� ��� �����Ƿ� ��ü ������ �� 
		// 10�� 0��°, �� 4��°���� ������ ����. 
		iArr[2] = 300; // ���⼭ ��ȣ �� 1�� index (����).. ����°�� 300�� ������.
		
		for (int j=0; j< iArr.length; j++) { // iArr.length : iArr �迭 ���� ������ ����.
		System.out.println(iArr[j] + ""); //���� �迭 ���� ����°��  ArrayIndexOutOfBoundsException �����߻�
		System.out.println(j + "��° ���� ����" + iArr[j]);
		}
		
		// 2. �迭 ���� ����� �迭 �޸� Ȯ��
		// �迭 ���� int i; �� ���������� ���� �ϰ� ���߿� ���� ���� �� ����.
		int [] iArr2 = new int[5]; // iArr2�� �� ���� Ȯ���� �� 0���� �ʱ�ȭ�� ����. �� {0,0,0,0,0}, new�� ������ Ȯ���Ѵٴ� �ǹ�. �����ʰ��� �ּҸ� �����´ٴ� ��. 
		iArr2[2] = 99; // {0,0,99,0,0}
		for (int idx =0 ; idx < iArr2.length; idx++) {
			System.out.println(iArr2[idx]);
			System.out.printf("iArr2[%d] = %d \n", idx, iArr2[idx]);
				
		
		}
		
		// 3. �迭 ���� ����
		int[] iArr3; // �迭�� �� ���� iArr3�� �������. �׷��� �迭�� �� ĭ���� �� �� ������ x 
		// iArr3[0] = 99; --> �迭�� �ʱ�ȭ���� �ʾ����Ƿ� 0��° ���� ���� ���ǵǰų� ���� �ٲ� �� ����.
		iArr3 = new int[3]; // {0,0,0} ���� �迭�� �ʱ�ȭ���־���.
		iArr3[0] = 99; // {99,0,0}
		for (int idx2=0 ; idx2 < iArr3.length; idx2++) {
			System.out.println(idx2 + "�� ° :" + iArr3[idx2]);
		}
		
	} // main
} // class
