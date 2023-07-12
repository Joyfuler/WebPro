package com.lec.quiz1;

import java.text.SimpleDateFormat;
import java.util.Date;


public class _Sawon2 {
	
	private String num;
	private String name;
	private String part;
	private Date date;
	
	
	public _Sawon2 (String num, String name, String part, Date date) {
		this.num = num;
		this.name = name;
		this.part = part;		
		this.date = date;
								
	}
	
	public String infoString() { //매개변수를 빼고 그대로 돌려주자.
		Date dateout = new Date(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String dateoutStr = sdf.format(dateout);
		return ("[사번]" + num + "[이름]" + name + "[부서]" + part + "[입사일]" + dateoutStr);
	}
	
}
