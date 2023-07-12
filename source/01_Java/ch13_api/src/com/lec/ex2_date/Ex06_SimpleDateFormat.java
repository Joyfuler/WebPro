package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex06_SimpleDateFormat {
	// 생년월일?
	public static void main(String[] args) {

		Date birth = new Date(1996 - 1900, 0, 20); // 1월 20일생인경우.. but 비추
		Date birth2 = new Date(new GregorianCalendar(1996,0,20,0,0,0).getTimeInMillis()); // 그레고리안 + 밀리세컨출력..
		SimpleDateFormat sdf1 = new SimpleDateFormat("생일은 yyyy년 MM월 dd일");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd"); // 간단하게 출력하려할때
		System.out.println(sdf1.format(birth2));
		System.out.println(sdf2.format(birth2));
	}
}
