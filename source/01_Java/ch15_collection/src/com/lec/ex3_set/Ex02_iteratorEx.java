package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex02_iteratorEx {
	public static void main(String[] args) {

		// 1. list (99.9% 사용...)
		ArrayList<String> list = new ArrayList<>();
		list.add("SAMPLE1");
		list.add("SAMPLE2");
		System.out.println(list); // 굳이 iterator를 하지 않아도 순서대로 출력됨.
		Iterator<String> iterator = list.iterator(); // idx가 없으므로 바로 뒤에 iterator()를 추가...
		for (String string : list) {
			System.out.println(string); // arraylist는 literator대신 for문통해서 순서대로 출력이 가능함.

		}
		System.out.println("-----------------------------");

		// while (iterator.hasNext()) {
		// System.out.println(iterator.next());
		// }
		// 2. map (0.1% 사용...)

		HashMap<String, Friend> hashmap = new HashMap<String, Friend>();
		hashmap.put("홍길동", new Friend("홍길동", "010-9999-9999"));
		hashmap.put("청길동", new Friend("청길동", "010-8888-9999"));
		// for문으로 뽑을수 없는경우... 너무 많아서 key값을 다 모르겠다면?
		System.out.println(hashmap.get("홍길동")); // 수가 적다면 이렇게 가능하지만.. 많다면 키들만 모아서 객체를 만들어야함.
		Iterator<String> iterator2 = hashmap.keySet().iterator();
		while (iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " : " + hashmap.get(key)); // hashmap의 key를 get하여 출력
		}
		System.out.println("-----------------------------------------");

		HashSet<Friend> hashset = new HashSet<Friend>();
		hashset.add(new Friend("홍길동", "010-9999-9999"));
		hashset.add(new Friend("청길동", "010-8888-9999")); //인덱스도, 키도 x. iterator 필수
		Iterator<Friend> iterator3 = hashset.iterator();
		while (iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
		
		// 3. set
	}
}
