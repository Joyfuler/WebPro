package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex06_SimpleDateFormat {
	// �������?
	public static void main(String[] args) {

		Date birth = new Date(1996 - 1900, 0, 20); // 1�� 20�ϻ��ΰ��.. but ����
		Date birth2 = new Date(new GregorianCalendar(1996,0,20,0,0,0).getTimeInMillis()); // �׷����� + �и��������..
		SimpleDateFormat sdf1 = new SimpleDateFormat("������ yyyy�� MM�� dd��");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd"); // �����ϰ� ����Ϸ��Ҷ�
		System.out.println(sdf1.format(birth2));
		System.out.println(sdf2.format(birth2));
	}
}
