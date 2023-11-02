package com.lec.ch03.method1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.Family;
import com.lec.ch03.Student;
import com.lec.ch03.StudentInfo;

public class Method1TestMain {
	public static void main(String[] args) {
		// 같은 패키지가 아닌 다른 패키지에 있는 것은 classpath를 그대로 사용하지 못함.
		String resourceLocation1 = "classpath:META-INF/method1_applicationCTX1.xml";
		String resourceLocation2 = "classpath:META-INF/method1_applicationCTX2.xml";
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(resourceLocation1, resourceLocation2);
		Student student1 = ctx.getBean("student1", Student.class);
		// bean의 이름과 그 타입. 
		System.out.println(student1);
		StudentInfo sInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student2 = sInfo.getStudent();
		System.out.println("student2 : " + student2);
		if (student1.equals(student2)) {
			System.out.println("student1과 student2는 같은 객체");
		} else {
			System.out.println("다른객체");			
		}
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println("student3 : " + student3);
		if (student3.equals(student2)) {
			System.out.println("student3과 student2는 같은 객체");
		} else {
			System.out.println("다른객체");			
		}
		
		Family f = ctx.getBean("family", Family.class);
		System.out.println("f : " + f);
		ctx.close();
	}
}
