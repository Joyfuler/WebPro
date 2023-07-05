package com.lec.ex08_customer;

public class Person { // super 이용해 호출하든지, name과 tel을 직접 입력해주든지.
	private String name;
	private String tel;
	
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	public String infoString() {
		return "[이름] " + name + " [전화] " + tel;
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
	
	
		
}
