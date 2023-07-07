package com.lec.quiz;

public abstract class Employee {
	private String name;

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
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
