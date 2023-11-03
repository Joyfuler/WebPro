package com.lec.ch05.ex1_env;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.Data;

@Data
public class Admin implements EnvironmentAware{
	private String adminId;
	private String adminPw;
	private Environment environment;
	
	@Override
	public void setEnvironment(Environment environment) {	
		System.out.println("bean 객체 실행시 바로 환경변수의 admin.id / admin.pw 가져옴");
		this.environment = environment;
		adminId = environment.getProperty("admin.id");
		adminPw = environment.getProperty("admin.pw");
	}
}
