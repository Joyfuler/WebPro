package com.lec.quiz1;

import java.util.Date;
import java.util.GregorianCalendar;

public class _Main2 {
	public static void main(String[] args) {

		Date startday = new Date();
		Date startday2 = new Date(new GregorianCalendar(2023, 06, 11).getTimeInMillis());
		
		// String start1Str = sdf.format(startday);
		// String start2Str = sdf.format(startday2);

		_Sawon2[] sawon = { new _Sawon2("a01", "ȫ�浿", "COMPUTER", startday),
				new _Sawon2("a02", "��浿", "DESIGN", startday2) };

		for (_Sawon2 sawon1 : sawon) {
			System.out.println(sawon1.infoString()); // �Ű������� ����!!
		}

	}
}
