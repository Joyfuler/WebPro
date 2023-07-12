package com.lec.ex2_date;

import java.io.ObjectInputStream.GetField;
import java.util.Calendar;

public class Ex01_Calendar {
	public static void main(String[] args) {
		// String date = "2023-07-12";
		Calendar now = Calendar.getInstance(); // Calendar�� ��������� ������ �� �ִ� ���� ����.
		System.out.println(now);
		// �̱����̹Ƿ�, new Calendar ��� get�� ����� ��ȸ�ϰ� ����. Calendar.getInstance();
		// now�� ���� ��¥�� �ð��� ����.
		// �ͼ��ϰ� '2023�� 7�� 12�� ������ ���� 10�� xx�� xx��' �� ����Ϸ���?
		// �ڹٽ�ũ��Ʈ ����
		int year = now.get(Calendar.YEAR); // ���� �������� ���. Year�� static�̹Ƿ� �빮�� �����.
		int month = now.get(Calendar.MONTH) + 1 ; // ��ǻ�ʹ� 0���� ����ϹǷ�, +1�� �������.
		int day = now.get(Calendar.DAY_OF_MONTH); // DAY �ڵ��ϼ�.  DAY_OF_MONTH
		int week = now.get(Calendar.DAY_OF_WEEK); // ������ Ȯ���ϴ� �Լ�. DAY_OF_WEEK
		// 1: ��, 2:��, 3:ȭ, 4:��, 5:��, 6:��, 7:��
		int hour24 = now.get(Calendar.HOUR_OF_DAY); // ~ of ~ : ~ �� ~ �ð� ��������? (24�ð�����)
		int hour = now.get(Calendar.HOUR); // (12�ð�����)
		int ampm = now.get(Calendar.AM_PM); // ��������, ��������. 0: ���� / 1: ����
		int minute = now.get(Calendar.MINUTE); // ��
		int second = now.get(Calendar.SECOND); // ��
		
		System.out.printf("%d�� %d�� %d�� ", year, month, day);
		switch (week) { // ������ �� �� ����. 
		case 1: System.out.print("�Ͽ��� ");			
		break;
		case 2: System.out.print("������ ");			
		break;
		case 3: System.out.print("ȭ���� ");			
		break;
		case 4: System.out.print("������ ");			
		break;
		case 5: System.out.print("����� ");			
		break;
		case 6: System.out.print("�ݿ��� ");			
		break;
		case 7: System.out.print("����� ");			
		break;
		
		}
		System.out.printf("%d��(%s %d��) %d�� %d��\n", hour24, ampm == 0? "����":"����", hour, minute, second);
		// %d ���� , %f �Ǽ�, %s ���ڿ�, %c ����, %b boolean
		// %tY(�⵵), %tm(��), %td(��) %ta(����) %tH(24��) %tp(����/����)  %tl (12�ð�����), %tM(��) %tS(��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tH�� (%tp %tl��) %tM�� %tS��\n",now,now,now,now,now,now,now,now,now); //now �� ���ϴ� �κ��� �޾Ƽ� ���. %tY~ %tM~
		
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tH�� (%1$tp %1$tl��) %1$tM�� %1$tS��",now);
	}
}
