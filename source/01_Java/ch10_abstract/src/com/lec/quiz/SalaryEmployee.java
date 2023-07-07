package com.lec.quiz;

public class SalaryEmployee extends Employee {

	private int pay;
	private int annualSalary;

	public SalaryEmployee(String name, int annualSalary) {
		super(name);
		this.annualSalary = annualSalary;
	}

	public int computePay() {
		pay = annualSalary / 14;
		return pay;
	}
}
