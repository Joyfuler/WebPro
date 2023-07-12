package com.lec.quiz1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {

	private String num;
	private String name;
	private String part;
	private Date date;

	public Sawon(String num, String name, String part) { // 당일입사인 경우
		this.num = num;
		this.name = name;
		this.part = part;
		date = new Date();
	}

	public Sawon(String num, String name, String part, int year, int month, int day) {
		this.num = num;
		this.name = name;
		this.part = part;
		date = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
	}

	public String infoString() { // 매개변수를 빼고 그대로 돌려주자. infoString() 에 뭐 들어가는거 봤음? ㅡㅡ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String dateoutStr = sdf.format(date);
		return ("[사번]" + num + " [이름]" + name + " [부서]" + part + " [입사일]" + dateoutStr);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd일");
		String dateoutStr = sdf.format(date);
		return ("[사번]" + num + " [이름]" + name + " [부서]" + part + " [입사일]" + dateoutStr);
		

	}
}
