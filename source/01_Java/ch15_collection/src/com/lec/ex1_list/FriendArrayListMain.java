package com.lec.ex1_list;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Date;

public class FriendArrayListMain {
	public static void main(String[] args) {
		/*
		 * Friend [] fs = new Friend[5]; // �� ���� �迭�� 5�������� ���� ��. fs[0] = new Friend
		 * ("ȫ�浿", "010-9999-9999", new Date(98,0,1)); // �������..
		 */
		ArrayList<Friend> friends = new ArrayList<>(); // ArrayList�� �����͸� ���Ӱ� ��������?
		friends.add(new Friend("ȫ�浿", "010-9999-9999")); // friends.add() �������� �߰�.
		friends.add(new Friend("��浿", "010-9999-9999", new Date(98, 6, 14)));
		friends.add(new Friend("���浿", "010-9999-9999", new Date(98, 6, 14)));
		friends.add(new Friend("�ڱ浿", "010-9999-9999", new Date(98, 5, 14)));
		friends.add(new Friend("���浿", "010-9999-9999", new Date(98, 11, 4)));
		for (Friend friend : friends) {
			System.out.println(friend);
		}
		for (int idx = 0; idx < friends.size(); idx++) {
			System.out.println(idx + " : " + friends.get(idx));
		}
		// 0�� �ε������� ������ �̸��� ����ϼ���.
		for (Friend friend : friends) {
			System.out.print(friend.getName() + "\t");
		}
		System.out.println();
		for (int idx = 0; idx < friends.size(); idx++) {
			System.out.print(idx + " : " + friends.get(idx).getName()+ "\t");

		}
	}
}
