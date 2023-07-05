package com.lec.ex06_this;
// this. : 내 객체의 ~
// this() : 현 클래스의 생성자 함수를 말함. this() --> 매개 x, this(10) --> int 매개 1
public class Friend {
	private String name;
	private String tel;
	
	public Friend() {
		System.out.println("매개변수가 없는 Friend 생성자");
	}
	
	public Friend(String name) {
		this(); // = Friend();를 다르게 쓴 것. Friend의 Friend()를 생성했으므로 혼동되지 않도록 함.
		this.name = name;
		System.out.println("매개변수가 하나인 Friend 생성자");
	}
	
	public Friend (String name, String tel) {
		this(name); // 바로 위의 Friend(String name)을 호출한 것. 해당 생성자함수가 먼저 출력됨. 위에서 this.name = name;을 입력했으므로 추가로 만들 필요는 없음.
		this.tel = tel;
		System.out.println("매개변수가 2개인 Friend 생성자");
	} 
	
	public String infoString() { // infoString 사용시 이름 : 전화번호 형식으로 return됨
		return name + " : " + tel;
	}
}
