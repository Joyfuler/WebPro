package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

// ������ �˻��� ��. (mm-dd)... 
// ������ ��ȭ��ȣ, �ּ� ���̶��?
// �����˻�

public class Ex04_FriendMain2 {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("ȫ�浿", "010-9999-9999", "���� ���빮��",
						new Date(new GregorianCalendar(1998, 11, 12).getTimeInMillis())),
				new Friend("�ű浿", "010-8888-9999", "���� ������",
						new Date(new GregorianCalendar(1996, 6, 13).getTimeInMillis())),
				new Friend("��浿", "010-8888-9999", "���� ������",
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
			System.out.print("�˻��� �ּҸ� '����' �������� �Է� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			String searchWord = scanner.next(); // 07-22 ��.
			 if (searchWord.equalsIgnoreCase("x")) {
				 System.out.println("�˻��� �����մϴ�.");
				 break;
			 }
			for (Friend friend : friends) {
				String adress = friend.getAddress(); // �Է��� ���� ��-�ϸ� �Է�.
				if (adress.indexOf(searchWord) != -1) { // ��,�ϸ� ǥ���ϴ� String ������ ���� �Է��� ���� ������ ��.
					System.out.println(friend);
					searchOk = true; // ã���� true�� ������. ã�� ���� ��� false�� ä��.
				} // if
			} // for
			if (!searchOk) {
				System.out.println("�ش� ������ ģ���� �����ϴ�.");

			}
		}
	}
}
