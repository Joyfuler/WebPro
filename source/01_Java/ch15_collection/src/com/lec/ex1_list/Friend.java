package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date date;

	public Friend(String name, String tel) { // 생일모름
		super();
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date date) {
		super();
		this.name = name;
		this.tel = tel;
		this.date = date;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		if (date != null) { // 날짜가 있다면 날짜출력. 
			return "[name]" + name + "\t[tel]" + tel + "\t[date]" + sdf.format(date);
		} // 없으면 날짜출력x
		return "[name]" + name + "\t[tel]" + tel + "\t[date] 미입력";
	}
	
	public Date getDate(){
	return date;
	}
	
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}

	}




