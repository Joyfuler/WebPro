package com.lec.ex2_map;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex02_FriendHashMap {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();  // friend �����͸� �Է�.. ��ȭ��ȣ�� �̸� ���� key������ Ȱ���� ���̹Ƿ� String�� �Է���.
		// ������ �Է�...
		
		friends.put("010-9999-9999", new Friend("ȫ�浿", "010-9999-9999")); // ������ �� ��ȭ��ȣ�� key������ �����.
		friends.put("010-8888-8888", new Friend("��浿", "010-8888-8888", new Date(new GregorianCalendar(98,6,14).getTimeInMillis()))); // �Ϲ������� key���� �ش� �迭�� ��ǥ���� �����. ex �̸�...
		friends.put("010-7777-7777", new Friend("���浿", "010-7777-7777", new Date(98, 6, 17)));
		// �ε����� �����Ƿ� for���� �̿��� ����� �Ұ���.
		Iterator<String> iterator = friends.keySet().iterator(); // iterator�� �������̽��� �߻�޼ҵ� ����. ���� new�� �Ұ���.
		// ��¿� �ʿ��� �ݺ���...
		while (iterator.hasNext()) {
			String key = iterator.next(); // ������° �迭�� �ֵ���? (ex 2��)
			System.out.println(key + "���� : " + friends.get(key).toString()); // (1���� ���. ���� ���� ���� ������..)
		}
	}
}
