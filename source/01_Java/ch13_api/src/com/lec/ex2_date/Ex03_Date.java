package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex03_Date {
	public static void main(String[] args) {
		Date now = new Date (); // ���� ����.
		Date nowThat = new Date(123, 6, 12); // Ư�� �ð��� �����ϰ� �ʹٸ�? 1900��뿡 ��������Ƿ�, 99���� 99, 2000���� 100, 2023�� 123���� �־�� ��.	
		// delete line?! ����õ...
		Date nowThat2 = new Date(new GregorianCalendar().getTimeInMillis()); // Ư�� ������ �Է�. 7�� 1���� ���.
		System.out.println(nowThat2); // Sat jul ... �ٲٷ��� �ᱹ �Ʒ��������� �ٽ� �ٲپ����...
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tH�� (%1$tp %1$tl��) %1$tM�� %1$tS��",nowThat2);
	}
}
