package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_SimpleDateFormat {
	public static void main(String[] args) {
		Date nowDate = new Date(); // 현재시각설정
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar nowGc = new GregorianCalendar(); // 3가지의 날짜 형식을 편하게 출력하려면? SimpleDateFormat 사용.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) (a) hh시 mm분 ss초 "); // E(대문자)는 요일, a는 오전/오후..
		// 스타일을 자신이 직접 만들어줌. a(오전/오후) H(24시) h(12시) m(분) s(초)..........w(올해 몇번째 주인지) W(이번달 몇번째 주인지) D(올해 몇번째 날인지) d(이번달 몇번째 날인지)
		// yyyy(년도 4자리) yy(년도 2자리) MM(대문자M 주의!) M (한자리인 경우, 07대신 7로 출력) dd(2자리) d(1자리)
		String nowDateStr = sdf.format(nowDate); // 현재시각을 대입해서 sdf 형식으로 출력하는 String 포맷으로 바꿔줌.
		System.out.println(nowDateStr);
		// 하지만 caldendar나 gregorian은 date로 대입이 불가능... 하는 방법은? gettime을 이용한다.
		String nowCalStr = sdf.format(nowCal.getTime()); 
		System.out.println(nowCalStr);
		String nowGcStr = sdf.format(nowGc.getTime());
		System.out.println(nowGcStr);	
		
	}
}
