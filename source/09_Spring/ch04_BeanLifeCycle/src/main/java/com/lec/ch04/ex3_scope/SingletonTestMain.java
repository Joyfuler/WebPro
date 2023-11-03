package com.lec.ch04.ex3_scope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class SingletonTestMain {
	public static void main(String[] args) {
		String loc = "classpath:META-INF/ex3/CTX.xml";
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(loc);
		Friend friend1 = ctx.getBean("friend", Friend.class);
		Friend friend2 = ctx.getBean("friend", Friend.class);
		// 두 개를 서로 가져왔는데, 각자 다른 객체가 생성된다는 설도 있고, friend1이 만든 것을 friend2가 다시 주소를 가져온다는 이야기도 있음. 이를 확인
		System.out.println("friend1 :" + friend1);
		System.out.println("firend2 :" + friend2);
		friend1.setName("장길동");
		// bean 객체는 생성시 기본적으로 싱글톤 패턴.
		// 처음 가져온 friend1을 싱글톤으로 friend2가 재사용하므로, friend1의 값을 바꾸면 friend2의 값도 변경됨.
		System.out.println("friend1 : " + friend1);
		System.out.println("friend2 : " + friend2);
		// 하지만 서로 다른 값을 사용하고 싶다면? (싱글톤 사용 x)
		System.out.println("----------아래의 빈은 싱글톤 사용 x인 채로 getBean--------");
		Friend friendProto1 = ctx.getBean("friendProto", Friend.class);
		Friend friendProto2 = ctx.getBean("friendProto", Friend.class);
		friendProto1.setFriendNo(333);
		friendProto1.setName("장길산");
		friendProto1.setTel("010-2525-3535");
		System.out.println(friendProto1);
		System.out.println(friendProto2);
		ctx.close();
		// scope = prototype를 사용하여 new한 것처럼 서로 다르게 사용할 수 있음.
	}
}
