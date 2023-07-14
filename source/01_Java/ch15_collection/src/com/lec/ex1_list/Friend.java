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
		if (date == new Date()) {
		return "[name]" + name + "\t[tel]" + tel + "\t[date]" + sdf.format(date);
		}
		return "[name]" + name + "\t[tel]" + tel;
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




