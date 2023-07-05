package com.lec.ex01_parentChild;

//childclass의 객체를 만드는 사전작업. (내용변경을 위해)
public class ChildTestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass(); // childclass중 매개변수가 없는 생성자부분을 출력하였음. childclass() { sisout...)
		// extends를 헀기에 부모클래스의 생성자 함수를 우선 실행함.
		System.out.println(child.pstr);
		System.out.println(child.cstr);
		child.getPapaName();
		child.getMamiName(); // child를 넣어서 부모 클래스에 있는 데이터를 모두 가져올 수 있음.
	}

}
