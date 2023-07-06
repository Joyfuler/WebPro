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
		return String.format("(번호)student%d\t(ID)%s\t (이름)%s\t (반)%s\n", cntStudent, getId(), getName(), ban); 
	}

}
