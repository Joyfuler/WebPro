package com.lec.ch04.ex2_life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Data;

@Data
public class OtherPerson {
	private String name;
	private String tel;
	@PostConstruct // 생성자 후에 실행
	public void initMethod() {
		System.out.println("★OtherPerson형 Bean 객체 생성시 호출 : initMethod()");
	}
	
	@PreDestroy // close 전에 실행
	public void preDestroy() {
		System.out.println("★OtherPerson형 Bean 객체 소멸시 호출 : preDestroy()");
	}
}
