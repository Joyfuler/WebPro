package com.lec.ex2_map;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

import com.lec.ex1_list.Friend;

public class Ex03_FriendHashMapSearchTel {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-9999-9999",
				new Friend("ȫ�浿", "010-9999-9999", new Date(new GregorianCalendar(98, 0, 1).getTimeInMillis())));
		friends.put("010-8888-9999",
				new Friend("ȫ�浿", "010-8888-9999", new Date(new GregorianCalendar(98, 6, 14).getTimeInMillis())));
		friends.put("010-7777-9999",
				new Friend("ȫ�浿", "010-7777-9999", new Date(new GregorianCalendar(98, 6, 17).getTimeInMillis())));
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("�˻��ϰ��� �ϴ� ��ȭ��ȣ�� �Է����ּ���. ���Ḧ ���ϸ� x�� �����ּ���.");
			String searchTel = scanner.nextLine();
			if (searchTel.equalsIgnoreCase("x")) {
				System.out.println("�˻��� �����մϴ�.");
				break;
			}
			Friend searchResult = friends.get(searchTel); // �Ϲ������� �޼ҵ� 2�� �ҷ����°� �� ���ϹǷ� ������ ����
			if (searchResult != null) { // ���� ��ȭ��ȣ�� ģ ���� �ƴ϶��? �˻������ ���
				System.out.println("�˻� ��� :" + searchResult);
			} else { // �Է��� ��ȭ��ȣ�� ���� ���
				System.out.println("�˻��� ��ȭ��ȣ�� ���� ��ȣ�Դϴ�.");
			}
		}

	}
}
