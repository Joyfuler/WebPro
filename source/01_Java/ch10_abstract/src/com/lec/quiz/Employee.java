package com.lec.quiz;

public abstract class Employee {
	private String name;
<<<<<<< HEAD

	public abstract int computePay(); // 추상메소드..아래에서 무조건오버라이드하도록.

	public Employee(String name) {
		this.name = name;
	}

	public final int computeIncentive() { // 오버라이드하지 말것.
		int temp = computePay();
		if (temp >= 3000000) {
			return (int) (temp * 0.05);
		}
		return 0;
=======
	public abstract int computePay(); // 추상메소드..
	public Employee(String name) {
	this.name = name;
	}
	public final int computeIncentive() {
		int temp = computePay();
		if (temp >= 3000000) {
			return (int) (temp * 1.05);
		}else {	return 0;}
>>>>>>> febfb5a (9th)
	}

	public String getName() {
		return name;
	}
<<<<<<< HEAD

	public void setName(String name) {
		this.name = name;
	}

}
=======
	
	public void setName(String name) {
		this.name = name;
	}	
		
}
	
	
>>>>>>> febfb5a (9th)
