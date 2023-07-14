package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ex04_FriendsTodayIsBirth {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<>(); // ArrayList로 데이터를 새롭게 넣으려면?
		friends.add(new Friend("홍길동", "010-9999-9999")); // friends.add() 형식으로 추가.
		friends.add(new Friend("김길동", "010-7676-7777", new Date(98, 6, 14)));
		friends.add(new Friend("마길동", "010-6565-6464", new Date(98, 6, 14)));
		friends.add(new Friend("박길동", "010-3535-6363", new Date(98, 5, 14)));
		friends.add(new Friend("윤길동", "010-2424-7565", new Date(98, 11, 4)));
		// 오늘이 생일인 친구만 출력.
		System.out.println("오늘이 생일인 친구는? : "); // 생일중 년은 빠짐.
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); // 그렇다면 simpledateformat을 사용해 같은 형식으로 만들어줌.
		String nowStr = sdf.format(now); // 오늘 날짜를 심플포맷으로 변경한 nowStr
		boolean none = true; // none이 true일 때는 생일 조건에 맞는 친구가 없는 것.
		for (Friend friend : friends) {
			Date birth = friend.getDate(); //
			if (birth != null && sdf.format(birth).equals(nowStr)) { // 오늘 생일인 사람의 데이터가 있는지를 비교
					System.out.print("\n" + friend);
					none = false; // 생일인 친구 출력.. // none이 false라면, 결국 생일인 사람이 없는 것. 아래 구문으로 이동.
				}
			}
			if (none) { // none이 true라면
				System.out.println("오늘 생일인 친구는 없습니다.");
		}

	}
}
