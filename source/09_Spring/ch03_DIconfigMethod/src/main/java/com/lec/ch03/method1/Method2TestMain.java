package com.lec.ch03.method1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.lec.ch03.Family;
import com.lec.ch03.Student;
import com.lec.ch03.StudentInfo;
import com.lec.ch03.method2.Method2ApplicationConfig;
import com.lec.ch03.method2.Method2ApplicationConfig2;

public class Method2TestMain {
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new AnnotationConfigApplicationContext(Method2ApplicationConfig.class, 
					Method2ApplicationConfig2.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		StudentInfo sInfo = ctx.getBean("sInfo", StudentInfo.class);
		Student student2 = sInfo.getStudent();
		// student2에 기존에 있던 student1 값이 대입됨. (config.java 클래스참조)
		if (student1.equals(student2)) {
			System.out.println("student1과 2가 같은 객체");
		} else {
			System.out.println("다른객체");
		}		
		
		Student student3 = ctx.getBean("student3", Student.class);
		Family family = ctx.getBean("family", Family.class);
		System.out.println("student1 :" + student1);
		System.out.println("student2 :" + student2);
		System.out.println("student3 :" + student3);
		System.out.println("Family :" + family);
		ctx.close();		
	}
}
