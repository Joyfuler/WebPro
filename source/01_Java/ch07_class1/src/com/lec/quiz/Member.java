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

		System.out.println("���̵� =" + id);
		System.out.println("�̸� = " + name);
		System.out.println("�̸��� = " + email);
		System.out.println("�ּ� = " + address);
		System.out.println("���� = " + birth);
		System.out.println("����= " + gender);

		// return String.format (" ���̵� = %s\n �̸� = %s\n �̸��� = %s\n �ּ� = %s\n ���� = %s\n
		// ���� = %c", id, name, email, address, birth, gender);
	}
}
