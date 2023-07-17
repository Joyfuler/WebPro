package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> list = new ArrayList<Friend>();
		list.add(new Friend("ȫ�浿", "����� ���빮��", "010-9999-1234",
				new Date(new GregorianCalendar(98, 04, 22).getTimeInMillis())));
		list.add(new Friend("�ű浿", "�����  ������", "010-9999-9999",
				new Date(new GregorianCalendar(98, 03, 05).getTimeInMillis())));
		list.add (new Friend("��浿", "��⵵ �Ⱦ��", "010-8888-6666", new Date(new GregorianCalendar(98,11,01).getTimeInMillis())));
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("�˻��� ���ϴ� �ּҸ� �Է����ּ���. ex) ���� / x�� ������ ����˴ϴ�.");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("x")) {
				System.out.println("�˻��� ����˴ϴ�.");
				break;
			} 
			boolean searchOk = false; // �ݺ��� �ȿ� �־��־�� �ٽ� false�� ��. �ٱ��� �θ� �� �� true�� �� �ڿ� �ٲ��� ����..
			for (Friend friend : list) {
				String address = friend.getAddress().substring(0, 2);
				if (input.equals(address)) {
					System.out.println(friend);
					searchOk = true; // ã�� ��� true�� �ٲ��ִ� �۾�.
					System.out.println();
				} 
			}
			if (searchOk != true) {
				System.out.println("�ش� �ּҸ� ���� ģ���� ã�� ���߽��ϴ�.");
			}
		}
	}
}