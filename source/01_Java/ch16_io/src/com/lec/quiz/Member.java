package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private Date date;
	private String address;

	public Member() {

	}

	public Member(String name, String tel, String address, Date date) {
		this.name = name;
		this.tel = tel;
		this.date = date;
		this.address = address;

	}

	@Override
	public String toString() {
		if (date == null) {
			return name + "\t" + tel + "\t생일모름\t" + address;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			return name + "\t" + tel + "\t" + sdf.format(date) + "생\t" + address + "\n";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
