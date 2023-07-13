package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

// ������ �˻��� ��. (mm-dd)... 
// ������ ��ȭ��ȣ, �ּ� ���̶��?
// �����˻�

public class Ex04_FriendMain4 {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("ȫ�浿", "010-9999-8888", "���� ���빮��",
						new Date(new GregorianCalendar(1998, 11, 12).getTimeInMillis())),
				new Friend("�ű浿", "010-8888-7777", "���� ������",
						new Date(new GregorianCalendar(1996, 6, 13).getTimeInMillis())),
				new Friend("��浿", "010-8888-6666", "��⵵ �Ⱦ��",
						new Date(new GregorianCalendar(1996, 6, 13).getTimeInMillis())),
				new Friend("�ڱ浿", "010-8888-9999", "���� ������",
						new Date(new GregorianCalendar(1996, 7, 22).getTimeInMillis())),
				new Friend("������", "010-8888-9999", "�԰�ϵ� û����",
						new Date(new GregorianCalendar(1996, 0, 22).getTimeInMillis())) };

		// �˻��� ���� �Է� - (07-22 ����...) => �迭�� ���� Ž�� (0��° �ε������� �����߿� MM-dd�� ������ ������ �� ��
		// ������ ���
		Scanner scanner = new Scanner(System.in);
		//
		boolean searchOk = false; // false�� ��� ��� �ݺ�.
		while (true) {
			System.out.print("�˻��� ��ȭ��ȣ�� '��ȭ��ȣ ���ڸ�(8888 ��) ���� �Է� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			String searchWord = scanner.next(); // 07-22 ��.
			if (searchWord.equalsIgnoreCase("x")) {
				System.out.println("�˻��� �����մϴ�.");
				break;
			}
			for (Friend friend : friends) {
				String phone = friend.getPhone(); // �Է��� ���� ��-�ϸ� �Է�.
				int idx = phone.lastIndexOf('-');
				if (phone.substring(idx + 1).equals(searchWord)) { 
					// ��,�ϸ� ǥ���ϴ� String ������ ���� �Է��� ���� ������ ��.
					System.out.println(friend);
					searchOk = true; // ã���� true�� ������. ã�� ���� ��� false�� ä��.
				} // if

			} // for
			if (!searchOk) { // while ������ ���� ��ġ�� ��.
				System.out.println("�ش� ��ȭ��ȣ�� ���� ģ���� �����ϴ�.");
			} // if

		} // while

	}// main
}
