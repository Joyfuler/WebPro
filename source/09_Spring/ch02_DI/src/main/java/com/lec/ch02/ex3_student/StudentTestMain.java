package com.lec.ch02.ex3_student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentTestMain {
	public static void main(String[] args) {
		//classpath는 본 소스가 있는 폴더를 말함.
		String location = "classpath:applcationCTX3.xml";
		AbstractApplicationContext ctx =
		new GenericXmlApplicationContext(location);			
		// 컨테이너 생성 - student1, student2, studentPrint bean 생성.
		StudentPrint sPrint = ctx.getBean("studentPrint", StudentPrint.class);
		sPrint.print();
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		if (sPrint.getStudent().equals(student1)) {
			System.out.println("sPrint의 student는 student1과 같은 객체");
		} else {
			System.out.println("sPrint의 stduent는 stduent1과 다른 객체");
		}
		sPrint.setStudent(student2);
		sPrint.print();
		if (sPrint.getStudent().equals(student1)) {
			System.out.println("sPrint의 student는 student1과 같은 객체");
		} else {
			System.out.println("sPrint의 stduent는 stduent1과 다른 객체");
		}
	}
}

