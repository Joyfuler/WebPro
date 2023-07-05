package com.lec.ex07_super;
// super. 및 super();
public class Person {
	private String name;
	private String character; // 이름과 성격만 저장...
	
	
	
	public Person() {
		System.out.println("매개변수 없는 Person 생성자");
	}



	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("매개변수 있는 Person 생성자");
	} // 상속받은 메서드에서 매개변수 없는 생성자를 출력하지 않게 하려면?
	
	public void intro() {
		System.out.println("★" + name + "은 " + character);
	}



	public String getName() { // name과 character가 모두 private이므로 외부에서 값을 넣거나 출력하기 위해서 getset 넣어줌.
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCharacter() {
		return character;
	}



	public void setCharacter(String character) {
		this.character = character;
	}
	
}
