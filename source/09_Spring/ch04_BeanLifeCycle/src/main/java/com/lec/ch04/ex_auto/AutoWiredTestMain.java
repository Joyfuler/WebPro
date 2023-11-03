package com.lec.ch04.ex_auto;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutoWiredTestMain {
	public static void main(String[] args) {
		String loc = "classpath:META-INF/CTX.xml";
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(loc);
		Student student = ctx.getBean("student", Student.class);
		StudentInfo sInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student2 = sInfo.getStudent();
		System.out.println(student);
		System.out.println(student2);
		if (student.equals(student2)) {
			System.out.println("같은객체");
		} else {
			System.out.println("다른객체");
		}
		ctx.close();
	}
}
