package com.lec.ex11_quiz;

public class Student extends Person {

	
<<<<<<< HEAD
	private static int cntStudent = 0;
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name, ban);
		++cntStudent;
		setNo("student"+cntStudent);
=======
	private int cntStudent = 0;
	private static int count;
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name, ban);
		this.ban = ban;
		++cntStudent;
>>>>>>> febfb5a (9th)
	}
	
	@Override
	public String infoString() {
<<<<<<< HEAD
		return String.format("(번호)%s\t(ID)%s\t (이름)%s\t (반)%s\n", getNo(), getId(), getName(), ban); 
=======
		return String.format("(번호)student%d\t(ID)%s\t (이름)%s\t (반)%s\n", cntStudent, getId(), getName(), ban); 
>>>>>>> febfb5a (9th)
	}

}
