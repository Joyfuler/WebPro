package com.lec.ex11_quiz;

public class Staff extends Person {

	
	private static int cntStaff = 0;
	private String department;
	public Staff(String id, String name, String department) {
		super(id, name, department);
	++cntStaff;
	this.department = department;
<<<<<<< HEAD
	setNo("staff"+ cntStaff);
	}
	
	public String infoString() {
		return String.format("(��ȣ)%s\t(ID)%s\t (�̸�)%s\t (�μ�)%s\n", getNo(), getId(), getName(), department); 
=======
	}
	
	public String infoString() {
		return String.format("(��ȣ)staff%d\t(ID)%s\t (�̸�)%s\t (�μ�)%s\n", cntStaff, getId(), getName(), department); 
>>>>>>> febfb5a (9th)
	}
		
}
