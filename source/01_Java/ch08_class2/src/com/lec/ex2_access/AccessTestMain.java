package com.lec.ex2_access;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest(); //obj라는 객체가 AccessTest 클래스에 있는 데이터를 참조함.
		// System.out.println(obj.privateMember); // not visible 오류. private이기 때문.
		// getter를 만들어 사용할 수도 있음.
		System.out.println(obj.defaultMember); // 같은 패키지이므로 가능.
		System.out.println(obj.protectedMember); // 같은 패키지이므로 가능.
		System.out.println(obj.publicMember); // 어디서나 가능.
		
		// obj.privateMethod(); // 메소드 호출 역시 불가능. 
		obj.defaultMethod(); // 같은 패키지.
		obj.protectedMethod(); // 같은.
		obj.publicMethod(); // 어디서든 가능.
			
		}
	}

