package com.lec.ex;

import java.util.Scanner;

public class Ex05_heightprac {
	public static void main(String[] args) {
		String[] name = {"��","��","��","��","��"};
		int[] height = new int[5];
		int totalheight = 0; //Ű ������
		Scanner scanner = new Scanner(System.in);
		for(int idx =0; idx <5; idx++) {
			System.out.println(name[idx] +"�� Ű�� �Է����ּ���.");
			height[idx] = scanner.nextInt();
			totalheight += height[idx];
			
		}
		for (int idx = 0; idx <5; idx++) {
			System.out.println(name[idx] + "�� Ű�� " + height[idx] + "�Դϴ�.");
			
		}
		
		System.out.println("�ټ� ���� Ű�� ���� " + totalheight + "�Դϴ�.");
		System.out.println("�ټ� ���� Ű�� ����� " + (totalheight) / (double)(name.length) + "�Դϴ�.");
		scanner.close();
		
		// �ڡ������, �ִܽ��� ����ϴ� ��
		int max = 0; int maxidx = 0;
		int min = 999; int minidx = 999; // �ڿ� ������ ����ǰ� �Ϸ��� ���� �۰� �ؾ��ϹǷ� �ʱⰪ�� ũ�� ������ ��.
		for (int idx = 0; idx <5; idx++) {
		if (height[idx] > max) {
			max = height[idx]; 
			maxidx = idx; // �ִ�Ű idx�� �������ִ� �۾�.
		}
		if (height[idx] < min) {
			min = height[idx];
			minidx= idx; // �ּ�Ű idx�� �������ִ� �۾�.
		}
		
		}
		System.out.printf("�ְ� Ű�� %d�̰�, �ּ� Ű�� %d�Դϴ�.\t", max,min);
		System.out.printf("�ְ� Ű�� ���� ����� %s �̰�, �ּ� Ű�� ���� ����� %s �Դϴ�.", name[maxidx], name[minidx]);
		
		}
	}


