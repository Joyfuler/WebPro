package com.lec.ch05.quiz;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("DEV(개발중) ? RUN(인수후) ?");
		String answer = scanner.next();
		if (answer.equalsIgnoreCase("DEV") || answer.equalsIgnoreCase("RUN")) {
			config = answer.toLowerCase();
		} else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다. 확인요망");
			System.exit(0);			
		}
		System.out.println(config);
		scanner.close();
		
		// 컨테이너생성
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext();
		// 환경변수에 위에서 입력한 config 변수를 대입함.
		ctx.getEnvironment().setActiveProfiles(config);		
		// profile이 config인 것만 active하고, 다른 것은 활성화하지 않도록 함.
		String location1 = "classpath:META-INF/ex4/run.xml";
		String location2 = "classpath:META-INF/ex4/dev.xml";
		ctx.load(location1, location2);
		ctx.refresh();
		EnvInfo info = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("ipNum : " + info.getIpNum());
		System.out.println("portNum : " + info.getPortNum());
		System.out.println("userId :" + info.getUserId());
		System.out.println("userPw :" + info.getUserPw());
		
	}
}
