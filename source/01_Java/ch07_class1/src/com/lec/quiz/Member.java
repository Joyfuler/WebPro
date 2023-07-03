package com.lec.quiz;

public class Member {
	private String id, name, email, address, birth; char gender;

	public Member(String id, String name, String email, String address, String birth, char gender) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}

	public void infoString() {

		System.out.println("아이디 =" + id);
		System.out.println("이름 = " + name);
		System.out.println("이메일 = " + email);
		System.out.println("주소 = " + address);
		System.out.println("생일 = " + birth);
		System.out.println("성별= " + gender);

		// return String.format (" 아이디 = %s\n 이름 = %s\n 이메일 = %s\n 주소 = %s\n 생일 = %s\n
		// 성별 = %c", id, name, email, address, birth, gender);
	}
}
