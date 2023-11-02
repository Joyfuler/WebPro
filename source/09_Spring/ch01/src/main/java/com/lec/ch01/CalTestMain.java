package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class CalTestMain {
	public static void main(String[] args) {
		/*
		 * Calculation cal = new Calculation(); cal.setNum1(10); cal.setNum2(5);
		 */
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Calculation cal = ctx.getBean("cal", Calculation.class);
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		ctx.close();		
	}
}
