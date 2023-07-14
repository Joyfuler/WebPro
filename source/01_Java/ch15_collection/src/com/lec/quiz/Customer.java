package com.lec.quiz;

public class Customer {
	private String name;
	private String tel;
	private String address;
	
	public Customer() {} // 매개변수 없는 생성자 함수도 미리 만들어놓는 습관을 들여놓을 것.
	
	public Customer(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}
	
	
	
	
	
	
}
