package com.lec.quiz;

public class Prac {

	private String id;
	private String name;
	private String email;
	private String address;
	private String birthday;
	private char gender;

	public Prac(String id, String name, String email, String address, String birthday, char gender) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;

		/*
		 * System.out.println("id :" + id); System.out.println("�̸�: " + name);
		 * System.out.println("�̸���: " + email); System.out.println("�ּ�: " + address);
		 * System.out.println("����: " + birthday); System.out.println("����: " + gender);
		 */
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

}
