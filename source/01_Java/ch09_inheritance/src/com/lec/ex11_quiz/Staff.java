package com.lec.ex11_quiz;

public class Staff extends Person {

	
	private static int cntStaff = 0;
	private String department;
	public Staff(String id, String name, String department) {
		super(id, name, department);
	++cntStaff;
	this.department = department;
	}
	
	public String infoString() {
		return String.format("(번호)staff%d\t(ID)%s\t (이름)%s\t (부서)%s\n", cntStaff, getId(), getName(), department); 
	}
		
}
