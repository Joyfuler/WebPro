package com.lec.ex2_map;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex02_FriendHashMap {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();  // friend 데이터를 입력.. 전화번호나 이름 등을 key값으로 활용할 것이므로 String을 입력함.
		// 데이터 입력...
		
		friends.put("010-9999-9999", new Friend("홍길동", "010-9999-9999")); // 데이터 중 전화번호를 key값으로 사용함.
		friends.put("010-8888-8888", new Friend("김길동", "010-8888-8888", new Date(new GregorianCalendar(98,6,14).getTimeInMillis()))); // 일반적으로 key값은 해당 배열의 대표값을 사용함. ex 이름...
		friends.put("010-7777-7777", new Friend("마길동", "010-7777-7777", new Date(98, 6, 17)));
		// 인덱스가 없으므로 for문을 이용한 출력이 불가능.
		Iterator<String> iterator = friends.keySet().iterator(); // iterator는 인터페이스로 추상메소드 존재. 따라서 new가 불가능.
		// 출력에 필요한 반복자...
		while (iterator.hasNext()) {
			String key = iterator.next(); // 다음번째 배열이 있따면? (ex 2번)
			System.out.println(key + "값은 : " + friends.get(key).toString()); // (1번을 출력. 다음 것이 없을 떄까지..)
		}
	}
}
