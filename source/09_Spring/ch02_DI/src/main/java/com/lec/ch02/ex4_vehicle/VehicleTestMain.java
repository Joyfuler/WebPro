package com.lec.ch02.ex4_vehicle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class VehicleTestMain {
	public static void main(String[] args) {
		// Bicycle bicycle = new Bicycle(); 기존방식
		// Vehicle vh = new Bicycle(); 인터페이스로도 받을 수 있었음
		AbstractApplicationContext ctx =
		new GenericXmlApplicationContext("classpath:applicationCTX4.xml");
		Vehicle vh = ctx.getBean("vh", Vehicle.class);
		// Bicycle도 사용할 수 있으나, 유지보수를 위하여 상위인 인터페이스를 대입한다.
		vh.ride("홍길동");	
		ctx.close();
	}
}
