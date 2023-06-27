package com.lec.ex; // 패키지(폴더)는 일반적으로 회사 이름에 맞춰 com. **. ** 식으로 작성. 실습은 com.lec.ex로

public class VarEx01 {
	public static void main(String[] args) {
		int age = 27; // 우항의 2 7을 age에 할당. int의 경우 21억까지 표시. * byte는 127까지
		 
		String name = "제니"; // String은 대문자로 시작함. 기본 자료형의 경우 소문자, 참조 자료형인 경우 대문자 표시
		name = "뷔";
		System.out.println("안녕하세요. " + age + "살 " + name + "씨" );
		System.out.println("안녕하세요. " + age + "살 " + name + "씨" ); // int 정수, string 문자열
		System.out.println("안녕하세요. 27살 제니씨");
	
		
	}

	
}
