package com.lec.ex1_list;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Date;

public class FriendArrayListMain {
	public static void main(String[] args) {
		/*
		 * Friend [] fs = new Friend[5]; // 이 경우는 배열에 5개까지만 값이 들어감. fs[0] = new Friend
		 * ("홍길동", "010-9999-9999", new Date(98,0,1)); // 기존방식..
		 */
		ArrayList<Friend> friends = new ArrayList<>(); // ArrayList로 데이터를 새롭게 넣으려면?
		friends.add(new Friend("홍길동", "010-9999-9999")); // friends.add() 형식으로 추가.
		friends.add(new Friend("김길동", "010-9999-9999", new Date(98, 6, 14)));
		friends.add(new Friend("마길동", "010-9999-9999", new Date(98, 6, 14)));
		friends.add(new Friend("박길동", "010-9999-9999", new Date(98, 5, 14)));
		friends.add(new Friend("윤길동", "010-9999-9999", new Date(98, 11, 4)));
		for (Friend friend : friends) {
			System.out.println(friend);
		}
		for (int idx = 0; idx < friends.size(); idx++) {
			System.out.println(idx + " : " + friends.get(idx));
		}
		// 0번 인덱스부터 끝까지 이름을 출력하세요.
		for (Friend friend : friends) {
			System.out.print(friend.getName() + "\t");
		}
		System.out.println();
		for (int idx = 0; idx < friends.size(); idx++) {
			System.out.print(idx + " : " + friends.get(idx).getName()+ "\t");

		}
	}
}
