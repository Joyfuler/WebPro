package com.lec.ex;

import java.util.Scanner;

public class Ex05_height {
	public static void main(String[] args) {
		// �ټ����� ģ�� Ű�� �Է��� �� �� ����� ���� ��.
		// ���� ūģ���� ���� ���� ģ���� ���. ���� ū ģ�� ~�� Ű�� ~cm...
		String[] member = {"����", "ö��", "�浿", "����", "����"};
		int[] height = new int[member.length]; // �켱 Ű �迭�� ����.
		int totalheight = 0; // �ӽú��� ����. Ű �ջ��
		Scanner scanner = new Scanner(System.in); //Ű �Է¹ޱ� 
		for(int i=0; i <=4; i++) {  // 5�� �ݺ��ϱ� ����
			System.out.println(member[i] + "��(��) Ű�� �Է����ּ���.");
			height[i] = scanner.nextInt();
		
		totalheight += height[i];
		
		
		
	}
		System.out.println("Ű�� ���հ�� " + totalheight + "�Դϴ�.");
		System.out.println("�ټ� ���� ��� Ű��" + (totalheight / (double)(height.length) + "�Դϴ�."));
		
		scanner.close();
	}
}
