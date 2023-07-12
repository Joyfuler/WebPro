package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

//
public class Ex04_term {
	public static void main(String[] args) {
	Date now1 = new Date(); // 현재날짜. 개강일인 6월 26일부터 지금까지 얼마나 지났는지?
	Date now2 = new Date(new GregorianCalendar(2023,5,26,9,30,0).getTimeInMillis()); // 그레고리안 6/26을 밀리세컨으로.. 달은 -1로 넣을것!!
	Date now3 = new Date(new GregorianCalendar(2023,11,11,18,0,0).getTimeInMillis());
	long now1Millis = now1.getTime();
	long now2Millis = now2.getTime(); // 기본 밀리세컨이라는 점을 주의.
	long now3Millis = now3.getTime();
	int day = (int)((now1Millis - now2Millis) / (1000*60*60*24));
	System.out.println("개강 후 지난 날은 " + day);
	int day2 = (int)((now3Millis - now1Millis) / (1000*60*60*24));
	System.out.println("수료까지 남은 날은 " + day2);
	}
}