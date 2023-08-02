package com.lec.ex11_quiz;

public class Student extends Person {

	
	private static int cntStudent = 0;
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name, ban);
		++cntStudent;
		setNo("student"+cntStudent);
	}
	
	@Override
	public String infoString() {
		return String.format("(번호)%s\t(ID)%s\t (이름)%s\t (반)%s\n", getNo(), getId(), getName(), ban); 
	}

}
