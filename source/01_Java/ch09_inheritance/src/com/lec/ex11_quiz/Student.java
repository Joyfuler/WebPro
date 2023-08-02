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
		return String.format("(��ȣ)%s\t(ID)%s\t (�̸�)%s\t (��)%s\n", getNo(), getId(), getName(), ban); 
	}

}
