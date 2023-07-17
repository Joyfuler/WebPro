package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("str0"); arr.add("str0");
		System.out.println(arr.get(0)); // get으로 데이터를 가져올 수 있음. 데이터의 키는 인덱스
		
		HashMap<Integer, String> hashmap = new HashMap<>();
		hashmap.put(11, "str1"); // 11은 키, str은 데이터.
		hashmap.put(11, "str11");
		hashmap.put(12, "str12");
		hashmap.put(33, "str22");
		hashmap.put(20, "str20");
		System.out.println("키 11을 가진 값 : " + hashmap.get(11)); // 데이터를 가져올 때는 get() 사용
		System.out.println("키 11을 가진 값 : " + hashmap.get(22));
		hashmap.remove(12); // key로만 제거가능. "str11" 등 값으로는 제거x 
		System.out.println(hashmap);
		System.out.println(hashmap.isEmpty() ? "데이터 없음" : "데이터 있음");
		hashmap.clear();
		System.out.println(hashmap.size() == 0 ? "데이터 없음" : "데이터 있음");
		hashmap.put(0, "Shin Gildong");
		hashmap.put(10, "Kim dongil");
		hashmap.put(22, "Lee soonsin");
		hashmap.put(40, "Shin gildong");
		// hashmap의 키값으로 만들어진 반복자.
		// Iterator<Integer> iterator = hashmap.keySet().iterator(); //
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while (iterator.hasNext()) { // iterator의 다음값이 있는 경우
		int key = iterator.next();// 다음값 뿌리기
		System.out.println(key + "값은 " + hashmap.get(key)); // 키값이 다르면 뒷값이 같아도 중복가능
			
		}
	}
}
