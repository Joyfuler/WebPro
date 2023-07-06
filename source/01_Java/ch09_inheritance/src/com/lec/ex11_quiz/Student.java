package com.lec.ex11_quiz;

public class Student extends Person {

	
	private int cntStudent = 0;
	private static int count;
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name, ban);
		this.ban = ban;
		++cntStudent;
	}
	
	@Override
	public String infoString() {
		return String.format("(��ȣ)student%d\t(ID)%s\t (�̸�)%s\t (��)%s\n", cntStudent, getId(), getName(), ban); 
	}

}
