package com.lec.ch02.ex1_cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String resources = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resources);
		// applicationCTX1에서 넣었던 bean 객체와 변수들을 모두 가져온다.
		MyCalculation myCal = ctx.getBean("myCal", MyCalculation.class);
		myCal.add();
		myCal.sub();
		myCal.mul();
		myCal.div();
		ctx.close();
	}
}
