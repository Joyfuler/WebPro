package com.lec.ch01;

public class CalTestMain {
	public static void main(String[] args) {
		Calculation cal = new Calculation();
		cal.setNum1(10);
		cal.setNum2(5);
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
	}
}
