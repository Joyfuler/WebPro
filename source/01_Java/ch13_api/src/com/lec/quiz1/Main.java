package com.lec.quiz1;

public class Main {
	public static void main(String[] args) {

		// Date startday = new Date();
		// Date startday2 = new Date(new GregorianCalendar(2023, 06,
		// 11).getTimeInMillis());

		// String start1Str = sdf.format(startday);
		// String start2Str = sdf.format(startday2);

		Sawon[] sawon = { new Sawon("a01", "È«±æµ¿", "COMPUTER"), 
						  new Sawon("a02", "±è±æµ¿", "DESIGN", 2023, 7, 11)};

		for (Sawon sawon1 : sawon) {
			System.out.println(sawon1); // ¸Å°³º¯¼ö¸¦ »©ÀÚ!!			
		}

	}
}
