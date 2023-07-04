package com.lec.ex2_access;

public class AccessTest {
	private int privateMember;  	// 같은 클래스 내에서만 사용할 수 있는 매개변수
	int defaultMember; 				// 기본값 (default). 같은 패키지에서만 사용가능
	protected int protectedMember;  // 같은 패키지 or 상속된 패키지에서만 사용가능.
	public int publicMember;	    // public. 어디에서든 사용할 수 있음.
	
	private void privateMethod() { // private이므로 이 클래스 내의 다른 메소드에서만 호출이 가능함.
		System.out.println("private 메소드 / privateMember: " + privateMember);				
	}
	void defaultMethod() {
		System.out.println("default 메소드");		
	}
	protected void protectedMethod() {
		System.out.println("protected 메소드");
	}
	
	public void publicMethod() {
		System.out.println("public 메소드");
	}
	
		
	


}
