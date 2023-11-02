package com.lec.ch03.method3;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.ch03.Student;

@Configuration
public class Method3ApplicationConfig {
// bean을 parsing할 클래스. method3은 xml과 혼합하여 사용할 예정.
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
