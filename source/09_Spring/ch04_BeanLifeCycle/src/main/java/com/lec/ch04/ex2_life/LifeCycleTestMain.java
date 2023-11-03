package com.lec.ch04.ex2_life;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LifeCycleTestMain {
	public static void main(String[] args) {
		String location = "classpath:META-INF/ex2/CTX.xml";
		// 지금까지는 컨테이너 생성과 파싱, 빈 생성을 한번에 했지만, 차후 사용을 위해서 단계를 분리할 예정.
		System.out.println("1. 컨테이너 생성");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("2. 파싱");
		ctx.load(location);
		System.out.println("3. Bean 객체 생성");
		ctx.refresh();
		System.out.println("4. Bean을 주입받아 사용");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		System.out.println("5. Container를 close");
		ctx.close();
	}
}
