package com.lec.ex01_parentChild;

// extends를 사용해 pstr, getPapaName(), getMamiName()등을 모두 들여옴.
public class ChildClass extends ParentClass {
	public String cstr = "자식클래스";
	public ChildClass() {
		System.out.println("자식클래스 생성자 함수");
		
		
		
	} 
	
}
