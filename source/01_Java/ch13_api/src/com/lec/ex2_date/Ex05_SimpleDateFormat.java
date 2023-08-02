package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_SimpleDateFormat {
	public static void main(String[] args) {
		Date nowDate = new Date(); // ����ð�����
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar nowGc = new GregorianCalendar(); // 3������ ��¥ ������ ���ϰ� ����Ϸ���? SimpleDateFormat ���.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E) (a) hh�� mm�� ss�� "); // E(�빮��)�� ����, a�� ����/����..
		// ��Ÿ���� �ڽ��� ���� �������. a(����/����) H(24��) h(12��) m(��) s(��)..........w(���� ���° ������) W(�̹��� ���° ������) D(���� ���° ������) d(�̹��� ���° ������)
		// yyyy(�⵵ 4�ڸ�) yy(�⵵ 2�ڸ�) MM(�빮��M ����!) M (���ڸ��� ���, 07��� 7�� ���) dd(2�ڸ�) d(1�ڸ�)
		String nowDateStr = sdf.format(nowDate); // ����ð��� �����ؼ� sdf �������� ����ϴ� String �������� �ٲ���.
		System.out.println(nowDateStr);
		// ������ caldendar�� gregorian�� date�� ������ �Ұ���... �ϴ� �����? gettime�� �̿��Ѵ�.
		String nowCalStr = sdf.format(nowCal.getTime()); 
		System.out.println(nowCalStr);
		String nowGcStr = sdf.format(nowGc.getTime());
		System.out.println(nowGcStr);	
		
	}
}
