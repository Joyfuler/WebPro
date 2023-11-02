package com.lec.ch03.method3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.Student;

public class MeThod3TestMain {
	public static void main(String[] args) {	
	String location = "classpath:META-INF/method3_applicationCTX.xml";
	// xml안에 java의 파싱 데이터를 context: 태그를 통하여 가져왔으므로, xml만 가져오면 된다.
	AbstractApplicationContext ctx =
			new GenericXmlApplicationContext(location);
	Student student1 = ctx.getBean("student1", Student.class);
	Student student2 = ctx.getBean("student2", Student.class);
	System.out.println("student1 :" + student1 );
	System.out.println("student2 :" + student2 );
	}
}
