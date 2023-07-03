package com.lec.quiz;

public class PracMain {

	public static void main(String[] args) {
		Prac a1 = new Prac("aaa", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", '남');

		System.out.println("id : " + a1.getId());
		System.out.println("이름 : " + a1.getName());
		System.out.println("이메일: " + a1.getEmail());
		System.out.println("주소 : " + a1.getAddress());
		System.out.println("생년월일 : " + a1.getBirthday());
		System.out.println("성별 : " + a1.getGender());

		System.out.println("-------------------이하 배열---------------");

		Prac[] a2 = { new Prac("aaa", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", '남'),
				new Prac("bbb", "신길동", "shin@company.com", "서울 강남구", "2000-11-01", '남') };

		for (int idx = 0; idx < a2.length; idx++) {
			System.out.println("id : " + a2[idx].getId());
			System.out.println("이름 : " + a2[idx].getName());
			System.out.println("이메일: " + a2[idx].getEmail());
			System.out.println("주소 : " + a2[idx].getAddress());
			System.out.println("생년월일 : " + a2[idx].getBirthday());
			System.out.println("성별 : " + a2[idx].getGender());
			System.out.println("----------------------------");

		}

	}
}
