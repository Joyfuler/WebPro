package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> list = new ArrayList<Friend>();
		list.add(new Friend("홍길동", "서울시 서대문구", "010-9999-1234",
				new Date(new GregorianCalendar(98, 04, 22).getTimeInMillis())));
		list.add(new Friend("신길동", "서울시  마포구", "010-9999-9999",
				new Date(new GregorianCalendar(98, 03, 05).getTimeInMillis())));
		list.add (new Friend("김길동", "경기도 안양시", "010-8888-6666", new Date(new GregorianCalendar(98,11,01).getTimeInMillis())));
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("검색을 원하는 주소를 입력해주세요. ex) 서울 / x를 누르면 종료됩니다.");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("x")) {
				System.out.println("검색이 종료됩니다.");
				break;
			} 
			boolean searchOk = false; // 반복문 안에 넣어주어야 다시 false가 됨. 바깥에 두면 한 번 true가 된 뒤에 바뀌지 않음..
			for (Friend friend : list) {
				String address = friend.getAddress().substring(0, 2);
				if (input.equals(address)) {
					System.out.println(friend);
					searchOk = true; // 찾는 경우 true로 바꿔주는 작업.
					System.out.println();
				} 
			}
			if (searchOk != true) {
				System.out.println("해당 주소를 가진 친구를 찾지 못했습니다.");
			}
		}
	}
}