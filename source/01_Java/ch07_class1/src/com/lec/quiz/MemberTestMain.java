package com.lec.quiz;

public class MemberTestMain {

	public static void main(String[] args) {

		Member m1 = new Member("aaa", "ȫ�浿", "hong@company.com", "���� ������", "2000-01-01", '��');
		m1.infoString();
		System.out.println("--------���� �迭---------");

		Member[] m2 = { new Member("aaa", "ȫ�浿", "hong@company.com", "���� ������", "2000-01-01", '��'),
				new Member("bbb", "�ű浿", "shin@company.com", "���� ������", "2000-11-01", '��') };

		// for (int idx = 0; idx < m2.length; idx++) {
		// m2[idx].infoString());
		// System.out.println("-----------------");

		for (Member member : m2) {
			member.infoString();
			System.out.println("-----------");

		}

	}
}
