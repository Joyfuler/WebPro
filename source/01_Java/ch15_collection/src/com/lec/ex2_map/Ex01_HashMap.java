package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("str0"); arr.add("str0");
		System.out.println(arr.get(0)); // get���� �����͸� ������ �� ����. �������� Ű�� �ε���
		
		HashMap<Integer, String> hashmap = new HashMap<>();
		hashmap.put(11, "str1"); // 11�� Ű, str�� ������.
		hashmap.put(11, "str11");
		hashmap.put(12, "str12");
		hashmap.put(33, "str22");
		hashmap.put(20, "str20");
		System.out.println("Ű 11�� ���� �� : " + hashmap.get(11)); // �����͸� ������ ���� get() ���
		System.out.println("Ű 11�� ���� �� : " + hashmap.get(22));
		hashmap.remove(12); // key�θ� ���Ű���. "str11" �� �����δ� ����x 
		System.out.println(hashmap);
		System.out.println(hashmap.isEmpty() ? "������ ����" : "������ ����");
		hashmap.clear();
		System.out.println(hashmap.size() == 0 ? "������ ����" : "������ ����");
		hashmap.put(0, "Shin Gildong");
		hashmap.put(10, "Kim dongil");
		hashmap.put(22, "Lee soonsin");
		hashmap.put(40, "Shin gildong");
		// hashmap�� Ű������ ������� �ݺ���.
		// Iterator<Integer> iterator = hashmap.keySet().iterator(); //
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while (iterator.hasNext()) { // iterator�� �������� �ִ� ���
		int key = iterator.next();// ������ �Ѹ���
		System.out.println(key + "���� " + hashmap.get(key)); // Ű���� �ٸ��� �ް��� ���Ƶ� �ߺ�����
			
		}
	}
}
