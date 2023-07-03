package com.lec.quiz;

public class MemberTestMain {

	public static void main(String[] args) {

		Member m1 = new Member("aaa", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", '남');
		m1.infoString();
		System.out.println("--------이하 배열---------");

		Member[] m2 = { new Member("aaa", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", '남'),
				new Member("bbb", "신길동", "shin@company.com", "서울 강남구", "2000-11-01", '남') };

		// for (int idx = 0; idx < m2.length; idx++) {
		// m2[idx].infoString());
		// System.out.println("-----------------");

		for (Member member : m2) {
			member.infoString();
			System.out.println("-----------");

		}

	}
}
