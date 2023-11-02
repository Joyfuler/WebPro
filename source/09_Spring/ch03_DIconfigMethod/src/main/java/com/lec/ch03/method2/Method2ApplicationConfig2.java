package com.lec.ch03.method2;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.ch03.Family;
import com.lec.ch03.Student;

@Configuration
public class Method2ApplicationConfig2 {
	@Bean
	public Student student3() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("그네타기");
		hobby.add("술마시기");
		hobby.add("수면");
		Student student3 = new Student("성춘향", 20, hobby);
		// 생성자함수에서 지정한 변수는 3개. 추가로 몸무게와 키를 직접 set해준다.
		student3.setHeight(160);
		student3.setWeight(50);
		return student3;
	}
	
	@Bean
	public Family family() {
		Family family = new Family("홍아빠", "김엄마");
		family.setSisterName("홍딸");
		family.setBroName("홍아들");
		return family;		
	}
}
