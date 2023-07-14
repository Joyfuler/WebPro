package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ex04_FriendsTodayIsBirth {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<>(); // ArrayList�� �����͸� ���Ӱ� ��������?
		friends.add(new Friend("ȫ�浿", "010-9999-9999")); // friends.add() �������� �߰�.
		friends.add(new Friend("��浿", "010-7676-7777", new Date(98, 6, 14)));
		friends.add(new Friend("���浿", "010-6565-6464", new Date(98, 6, 14)));
		friends.add(new Friend("�ڱ浿", "010-3535-6363", new Date(98, 5, 14)));
		friends.add(new Friend("���浿", "010-2424-7565", new Date(98, 11, 4)));
		// ������ ������ ģ���� ���.
		System.out.println("������ ������ ģ����? : "); // ������ ���� ����.
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); // �׷��ٸ� simpledateformat�� ����� ���� �������� �������.
		String nowStr = sdf.format(now); // ���� ��¥�� ������������ ������ nowStr
		boolean none = true; // none�� true�� ���� ���� ���ǿ� �´� ģ���� ���� ��.
		for (Friend friend : friends) {
			Date birth = friend.getDate(); //
			if (birth != null && sdf.format(birth).equals(nowStr)) { // ���� ������ ����� �����Ͱ� �ִ����� ��
					System.out.print("\n" + friend);
					none = false; // ������ ģ�� ���.. // none�� false���, �ᱹ ������ ����� ���� ��. �Ʒ� �������� �̵�.
				}
			}
			if (none) { // none�� true���
				System.out.println("���� ������ ģ���� �����ϴ�.");
		}

	}
}
