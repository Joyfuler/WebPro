package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_GregorianCalendar {
	public static void main(String[] args) {
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar now = new GregorianCalendar(); // 매개변수를 넣지 않는 경우 현재 시간이 저장됨. 
		GregorianCalendar now2 = new GregorianCalendar(2023,06,12); //특정한 날을 지정할 수 있음.
		
		
		int year = now.get(Calendar.YEAR); // 년을 가져오는 방법. Year는 static이므로 대문자 상수로.
		int month = now.get(Calendar.MONTH) + 1 ; // 컴퓨터는 0부터 계산하므로, +1을 해줘야함.
		int day = now.get(Calendar.DAY_OF_MONTH); // DAY 자동완성.  DAY_OF_MONTH
		int week = now.get(Calendar.DAY_OF_WEEK); // 요일을 확인하는 함수. DAY_OF_WEEK
		// 1: 일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토
		int hour24 = now.get(Calendar.HOUR_OF_DAY); // ~ of ~ : ~ 중 ~ 시간 지났는지? (24시간단위)
		int hour = now.get(Calendar.HOUR); // (12시간단위)
		int ampm = now.get(Calendar.AM_PM); // 오전인지, 오후인지. 0: 오전 / 1: 오후
		int minute = now.get(Calendar.MINUTE); // 분
		int second = now.get(Calendar.SECOND); // 초
		
		
		System.out.printf("%d시(%s %d시) %d분 %d초\n", hour24, ampm == 0? "오전":"오후", hour, minute, second);
		// %d 정수 , %f 실수, %s 문자열, %c 문자, %b boolean
		// %tY(년도), %tm(월), %td(일) %ta(요일) %tH(24시) %tp(오전/오후)  %tl (12시간단위), %tM(분) %tS(초)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tH시 (%tp %tl시) %tM분 %tS초\n",now,now,now,now,now,now,now,now,now); //now 중 원하는 부분을 받아서 출력. %tY~ %tM~
		
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 (%1$tp %1$tl시) %1$tM분 %1$tS초",now);
	}
}
