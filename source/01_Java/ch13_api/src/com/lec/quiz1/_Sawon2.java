package com.lec.quiz1;

import java.text.SimpleDateFormat;
import java.util.Date;


public class _Sawon2 {
	
	private String num;
	private String name;
	private String part;
	private Date date;
	
	
	public _Sawon2 (String num, String name, String part, Date date) {
		this.num = num;
		this.name = name;
		this.part = part;		
		this.date = date;
								
	}
	
	public String infoString() { //�Ű������� ���� �״�� ��������.
		Date dateout = new Date(date.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String dateoutStr = sdf.format(dateout);
		return ("[���]" + num + "[�̸�]" + name + "[�μ�]" + part + "[�Ի���]" + dateoutStr);
	}
	
}
