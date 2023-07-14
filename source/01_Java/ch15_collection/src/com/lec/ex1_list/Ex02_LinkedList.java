package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex02_LinkedList {
	public static void main(String[] args) {
		int[] arr = new int[5]; // �� 5 ĭ¥�� int�迭����

		String[] array = new String[3]; // String�� �迭.
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		System.out.println(Arrays.toString(array)); // �迭�� �ٷ� ����ϴ� ���. Arrays.tostring() �̿�.. Ȥ��
		for (String arrs : array) {
			System.out.println(arrs); // ������ ��� ������. �迭 ���ڿ� �Բ� ���������� for�����.
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " �� �ε��� �� : " + array[i]); // �׷��� �迭�� ���ڸ� �ø��ų� ���� �� ���ٴ� ����

		}

		System.out.println("---------------------------ArrayList--------------------------------");

		ArrayList<String> arrayList = new ArrayList<>(); // String�� arraylist
		arrayList.add("str0"); // 0�� �ε����� str ���� �Ͱ� ������.
		arrayList.add("str0");
		arrayList.add("str0"); // �迭 ���̸� ����ؼ� �߰��� ����.
		arrayList.add(1, "str1111"); // 1�� �ε������� �߰��� ���� ����. �� ��� 1�� ���� �ε����� �ִ� �����ʹ� ��ĭ�� ������.
		arrayList.set(2, "str2222"); // set�� ���� �ε����� ����, �ش� �迭�� �����͸� ������ ���� ����.
		System.out.println("arrayList�� ������ : " + arrayList.size()); // ���� arraylist�� size�� 0�̶��, �ش��ϴ� db�� ���ٴ� �ǹ�.
		arrayList.add("str4");
		System.out.println("arrayList�� ������ : " + arrayList.size());
		System.out.println(arrayList); // sout�� �ֱ⸸ �ϸ�, �˾Ƽ� ����� ������. ���� �迭�� ���� arrays.tostring ����ʿ�..
		// ���� for���� �����ٸ�?
		for (String strings : arrayList) {
			System.out.print(strings + "\t");			
		}
		for (int i =0; i < arrayList.size(); i++) {
			System.out.println(i + "��° �ε��� �� : + " + arrayList.get(i)); // �Ϲ� �迭���� �޸�, get(int i) �� �Է���. 
		}
		//arrayList.remove(2);
		arrayList.remove("str2222");
		arrayList.remove(arrayList.size()-1);
		System.out.println("2 �� �ε��� ���� ������ �� remove ��");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(i + "�� �ε��� �� : " + arrayList.get(i));			
		}
		arrayList.clear(); // �ش� arrayList�� ��� ���� 0���� û����. (��, arrayList�� ��ü�� ��������)
		System.out.println(arrayList.size()==0? "������ ���� �Ϸ�" : "������ ����");
		System.out.println(arrayList.isEmpty()? "������ ���� �Ϸ�" : "������ ����");
		// isEMpty���� ��������� true ����, �ƴϸ� false ����
		// ���� arrayList ��ü�� ���ְ� �ʹٸ�? null�� ����
		//arrayList = null;
		//System.out.println(arrayList.size());
	}
}
