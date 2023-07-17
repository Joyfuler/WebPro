package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		/*
		 * String s0 = "str0"; String s1 = new String("str0");
		 * System.out.println(s0==s1); // 둘의 주소가 다르므로 이렇게 비교하는 경우는 false가 나옴. 그러나...
		 * System.out.println(s0.equals(s1)); // 둘의 값만 비교하면 true가 나옴. 또한
		 * System.out.println(s0.hashCode()); System.out.println(s1.hashCode()); // 둘의
		 * 해시코드도 동일하게 출력됨.
		 */		
		
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("str0");
		hashset.add("str1"); // 두번쨰 데이터를 넣을 때, 첫번째 데이터와 값이 다를 경우(false)인 경우 추가함.
		hashset.add("str2"); // 세번째 데이터를 넣을 떄, 첫번째 데이터와 값 비교 후 두번째 데이터와 값 비교
		System.out.println(hashset); //동일한값을 넣을때
		System.out.println(hashset.size());
		hashset.add("str2"); // 네번째 데이터를 넣으려고 하는데, 세번째 데이터와 값을 비교한 결과 true가 나옴.
								// 만일 같다면, "str2".hashcode()와 "str2".hashcode() 결과 비교하여 true라면?
		System.out.println("중복 데이터 add 후 " + hashset); // 해당 값은 추가되지 않는 결과.
		System.out.println("중복 데이터 add 후 " + hashset.size());
		Iterator<String> iterator = hashset.iterator(); // 키가 없으므로 getkey가 불가능.
		while (iterator.hasNext()) {
			System.out.println(iterator.next()); // 배열에 다음 값이 있는동안 출력. 단, idx가 없으므로 순서는 무작위
		}
	}
}
