package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

//
public class Ex04_term {
	public static void main(String[] args) {
	Date now1 = new Date(); // ���糯¥. �������� 6�� 26�Ϻ��� ���ݱ��� �󸶳� ��������?
	Date now2 = new Date(new GregorianCalendar(2023,5,26,9,30,0).getTimeInMillis()); // �׷����� 6/26�� �и���������.. ���� -1�� ������!!
	Date now3 = new Date(new GregorianCalendar(2023,11,11,18,0,0).getTimeInMillis());
	long now1Millis = now1.getTime();
	long now2Millis = now2.getTime(); // �⺻ �и������̶�� ���� ����.
	long now3Millis = now3.getTime();
	int day = (int)((now1Millis - now2Millis) / (1000*60*60*24));
	System.out.println("���� �� ���� ���� " + day);
	int day2 = (int)((now3Millis - now1Millis) / (1000*60*60*24));
	System.out.println("������� ���� ���� " + day2);
	}
}