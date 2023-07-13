package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
// new Friend("홍","010-9999-9999", "서울 서대문구", new Date(new GregorianCalendar(1998,11,12).getTime~
public class Friend {
	private String name;
	private String phone;
	private String address;
	private Date birth;
	
	public Friend(String name, String phone, String address, Date birth) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birth = birth;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "이름: " + name + "\n전화번호 : " + phone + "\n주소 : " + address + "\n생일 : " + sdf.format(birth) + "\n\n";
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirth() {
		return birth;
	}
	
	
	
	
	
	
	
}
