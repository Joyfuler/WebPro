package com.lec.ex07_super;
// private (name, character), public (intro(), setget있음
// super() : 부모 클래스의 생성자 함수
// this() : 이 클래스의 생성자 함수를 말하는 것.
// super. 부모 클래스의 ~
// this. : 내 객체의~
public class Baby extends Person{


	public Baby() {
		super(); //부모클래스의 생성자함수
		System.out.println("매개변수 없는 Baby 생성자");
	}
	
	public Baby (String name, String character) {
		/*
		 * setName(name); setCharacter(character);
		 */
		super(name,character); // 매개변수가 있는.. 부모 클래스인 Person(name,character);와 동일한 값 출력. Person()은 수행하지 않음.
		System.out.println("매개변수 있는 Baby 생성자");
			
	}
	@Override
	public void intro() { // 애기쪽 소개를 super와 다르게 바꾸고 싶다면...
		System.out.print("☆응애 응애 이쁜 아기");
		super.intro(); // 부모 클래스의 intro() 호출..
	}
	
	
}
