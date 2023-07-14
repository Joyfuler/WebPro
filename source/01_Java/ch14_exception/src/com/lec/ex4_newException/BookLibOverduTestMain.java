package com.lec.ex4_newException;

import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.GregorianCalendar;

// å��ü ���� -> ���� -> ������(20�������� ����) -> �ݳ� 
public class BookLibOverduTestMain {
	public static void main(String[] args) {
		Book book = new Book("950-��10", "�̰��� �ڹٴ�", "�ſ��");
		System.out.println("���� �� : " + book);
		book.checkout("ȫ�浿"); // ����.
		//book.setCheckoutDate(new Date (2023-1900, 5, 23)); // 6�� 23�Ϸ� ��¥����
		book.setCheckoutDate(new Date(new GregorianCalendar(2023,5,23).getTimeInMillis()));
		System.out.println("���� �� : " + book);
		try { // �ݳ��� ���� ������ �̸� �����ϰ� �ֱ�
			book.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("�ݳ�ó�� Ȯ�� : " + book);
	} 
}
