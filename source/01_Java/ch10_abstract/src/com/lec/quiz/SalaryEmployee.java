package com.lec.quiz;

public class SalaryEmployee extends Employee {

	private String name;
	private int pay;
	private int annualSalary;
	private int incentive;
	
	
		
	public SalaryEmployee(String name, int annualSalary) {
		super(name);
		this.name = name;
		this.annualSalary = annualSalary;			
	}	
		
	public int computePay() {
		pay = annualSalary / 14;
		if (pay >= 3000000) {
			return (int) (pay * 1.05);
		} else {
			return pay;}
	}
}


	
	


	


	

	





