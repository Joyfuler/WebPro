package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

// 생일을 검색한 것. (mm-dd)... 
// 하지만 전화번호, 주소 등이라면?
// 지역검색

public class Ex04_FriendMain2 {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("홍길동", "010-9999-9999", "서울 서대문구",
						new Date(new GregorianCalendar(1998, 11, 12).getTimeInMillis())),
				new Friend("신길동", "010-8888-9999", "서울 마포구",
						new Date(new GregorianCalendar(1996, 6, 13).getTimeInMillis())),
				new Friend("김길동", "010-8888-9999", "서울 마포구",
						new Date(new GregorianCalendar(1996, 6, 13).getTimeInMillis())),
				new Friend("박길동", "010-8888-9999", "서울 마포구",
						new Date(new GregorianCalendar(1996, 7, 22).getTimeInMillis())),
				new Friend("윤동주", "010-8888-9999", "함경북도 청진시",
						new Date(new GregorianCalendar(1996, 0, 22).getTimeInMillis())) };

		// 검색할 생일 입력 - (07-22 형식...) => 배열을 통해 탐색 (0번째 인덱스부터 생일중에 MM-dd만 추출한 정보를 비교 후
		// 같으면 출력
		Scanner scanner = new Scanner(System.in);
		//
		boolean searchOk = false; // false인 경우 계속 반복.
		while (true) {
			System.out.print("검색할 주소를 '서울' 형식으로 입력 (단, 종료를 원하시면 x를 입력하시오) : ");
			String searchWord = scanner.next(); // 07-22 등.
			 if (searchWord.equalsIgnoreCase("x")) {
				 System.out.println("검색을 종료합니다.");
				 break;
			 }
			for (Friend friend : friends) {
				String adress = friend.getAddress(); // 입력할 때는 월-일만 입력.
				if (adress.indexOf(searchWord) != -1) { // 월,일만 표기하는 String 변수의 값과 입력한 값이 같으면 됨.
					System.out.println(friend);
					searchOk = true; // 찾으면 true로 변경함. 찾지 못한 경우 false인 채로.
				} // if
			} // for
			if (!searchOk) {
				System.out.println("해당 지역의 친구는 없습니다.");

			}
		}
	}
}
