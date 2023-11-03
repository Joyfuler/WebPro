package com.lec.ch03.method4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.lec.ch03.Student;

@Configuration
@ImportResource("classpath:META-INF/method4_applicationCTX.xml")
// student1이 담긴 xml 파일 정보. 이를 Import함으로서 main에서는 이 클래스만 가져와도 student1, student2를
// 모두 가져올 수 있다.
public class Method4ApplicationConfig {

	@Bean
	public Student student2() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("게임");
		hobby.add("잠");
		hobby.add("밥먹기");
		String name = "성춘향";
		int age = 20;	
		Student student = new Student(name, age, hobby);
		student.setHeight(170);
		student.setWeight(33);
		return student;		
	}
}
