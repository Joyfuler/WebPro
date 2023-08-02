package com.lec.ex11_quiz;

public class Gangsa extends Person {

	
	private int cntGangsa=0;
	private static int count;
	private String subject;
	public Gangsa(String id, String name, String subject) {
		super(id, name, subject);
	
	this.subject = subject;
	++cntGangsa;
	setNo("lecturer"+ cntGangsa);
	
		
	}
	
	@Override
	public String infoString() {
	return String.format("(번호)%s\t(ID)%s\t (이름)%s\t (과목)%s\n", getNo(), getId(), getName(), subject); 
	}

}
