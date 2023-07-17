package com.lec.ex2_map;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

import com.lec.ex1_list.Friend;

public class Ex03_FriendHashMapSearchTel {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-9999-9999",
				new Friend("홍길동", "010-9999-9999", new Date(new GregorianCalendar(98, 0, 1).getTimeInMillis())));
		friends.put("010-8888-9999",
				new Friend("홍길동", "010-8888-9999", new Date(new GregorianCalendar(98, 6, 14).getTimeInMillis())));
		friends.put("010-7777-9999",
				new Friend("홍길동", "010-7777-9999", new Date(new GregorianCalendar(98, 6, 17).getTimeInMillis())));
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("검색하고자 하는 전화번호를 입력해주세요. 종료를 원하면 x를 눌러주세요.");
			String searchTel = scanner.nextLine();
			if (searchTel.equalsIgnoreCase("x")) {
				System.out.println("검색을 종료합니다.");
				break;
			}
			Friend searchResult = friends.get(searchTel); // 일반적으로 메소드 2번 불러오는걸 잘 안하므로 변수를 생성
			if (searchResult != null) { // 없는 전화번호를 친 것이 아니라면? 검색결과를 출력
				System.out.println("검색 결과 :" + searchResult);
			} else { // 입력한 전화번호가 없는 경우
				System.out.println("검색한 전화번호는 없는 번호입니다.");
			}
		}

	}
}
