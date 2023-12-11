package com.lec.quiz;

public class HourlyEmployee extends Employee {

<<<<<<< HEAD
	private int hoursWorked;
	private int moneyPerHour;

	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}

=======
	private String name;
	private int hoursWorked;
	private int moneyPerHour;
	
		

	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.name = name;
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}
	
>>>>>>> febfb5a (9th)
	@Override
	public int computePay() {
		return (hoursWorked * moneyPerHour);
	}
<<<<<<< HEAD
=======
	
	
>>>>>>> febfb5a (9th)

}
