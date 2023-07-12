package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex03_Date {
	public static void main(String[] args) {
		Date now = new Date (); // 현재 시점.
		Date nowThat = new Date(123, 6, 12); // 특정 시간을 저장하고 싶다면? 1900년대에 만들었으므로, 99년은 99, 2000년은 100, 2023은 123으로 넣어야 함.	
		// delete line?! 비추천...
		Date nowThat2 = new Date(new GregorianCalendar().getTimeInMillis()); // 특정 시점을 입력. 7월 1일이 출력.
		System.out.println(nowThat2); // Sat jul ... 바꾸려면 결국 아래형식으로 다시 바꾸어줘야...
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 (%1$tp %1$tl시) %1$tM분 %1$tS초",nowThat2);
	}
}
