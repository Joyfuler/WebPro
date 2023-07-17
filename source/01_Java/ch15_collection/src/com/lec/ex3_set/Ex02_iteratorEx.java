package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex02_iteratorEx {
	public static void main(String[] args) {

		// 1. list (99.9% ���...)
		ArrayList<String> list = new ArrayList<>();
		list.add("SAMPLE1");
		list.add("SAMPLE2");
		System.out.println(list); // ���� iterator�� ���� �ʾƵ� ������� ��µ�.
		Iterator<String> iterator = list.iterator(); // idx�� �����Ƿ� �ٷ� �ڿ� iterator()�� �߰�...
		for (String string : list) {
			System.out.println(string); // arraylist�� literator��� for�����ؼ� ������� ����� ������.

		}
		System.out.println("-----------------------------");

		// while (iterator.hasNext()) {
		// System.out.println(iterator.next());
		// }
		// 2. map (0.1% ���...)

		HashMap<String, Friend> hashmap = new HashMap<String, Friend>();
		hashmap.put("ȫ�浿", new Friend("ȫ�浿", "010-9999-9999"));
		hashmap.put("û�浿", new Friend("û�浿", "010-8888-9999"));
		// for������ ������ ���°��... �ʹ� ���Ƽ� key���� �� �𸣰ڴٸ�?
		System.out.println(hashmap.get("ȫ�浿")); // ���� ���ٸ� �̷��� ����������.. ���ٸ� Ű�鸸 ��Ƽ� ��ü�� ��������.
		Iterator<String> iterator2 = hashmap.keySet().iterator();
		while (iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " : " + hashmap.get(key)); // hashmap�� key�� get�Ͽ� ���
		}
		System.out.println("-----------------------------------------");

		HashSet<Friend> hashset = new HashSet<Friend>();
		hashset.add(new Friend("ȫ�浿", "010-9999-9999"));
		hashset.add(new Friend("û�浿", "010-8888-9999")); //�ε�����, Ű�� x. iterator �ʼ�
		Iterator<Friend> iterator3 = hashset.iterator();
		while (iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
		
		// 3. set
	}
}
