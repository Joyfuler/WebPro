package com.lec.quiz;

public abstract class Employee {
	private String name;
	public abstract int computePay(); // 추상메소드..
	public Employee(String name) {
	this.name = name;
	}
	public final int computeIncentive() {
		int temp = computePay();
		if (temp >= 3000000) {
			return (int) (temp * 1.05);
		}else {	return 0;}
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
		
}
	
	