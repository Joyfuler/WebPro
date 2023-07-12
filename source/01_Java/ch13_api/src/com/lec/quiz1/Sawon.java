package com.lec.quiz1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {

	private String num;
	private String name;
	private String part;
	private Date date;

	public Sawon(String num, String name, String part) { // �����Ի��� ���
		this.num = num;
		this.name = name;
		this.part = part;
		date = new Date();
	}

	public Sawon(String num, String name, String part, int year, int month, int day) {
		this.num = num;
		this.name = name;
		this.part = part;
		date = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
	}

	public String infoString() { // �Ű������� ���� �״�� ��������. infoString() �� �� ���°� ����? �Ѥ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String dateoutStr = sdf.format(date);
		return ("[���]" + num + " [�̸�]" + name + " [�μ�]" + part + " [�Ի���]" + dateoutStr);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd��");
		String dateoutStr = sdf.format(date);
		return ("[���]" + num + " [�̸�]" + name + " [�μ�]" + part + " [�Ի���]" + dateoutStr);
		

	}
}
