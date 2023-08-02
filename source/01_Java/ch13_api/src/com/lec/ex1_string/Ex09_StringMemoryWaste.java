package com.lec.ex1_string;

public class Ex09_StringMemoryWaste {
	public static void main(String[] args) {
		String str = "Hello, java";
		System.out.println(str); // str의 주소를 직접 볼 수가 없음. 해쉬코드로 대체...
		System.out.println(str.hashCode()); // 해시코드 확인
		str = "Hello, JAVA"; // 값이 바뀌는 경우, 기존 값을 버리고 새롭게 개체를 생성.
		System.out.println(str.hashCode()); // 기존 값은 쓰레기로 남아서 메모리를 낭비함.
		str = "Hello, C";
		System.out.println(str.hashCode()); // String의 값을 바꿀 때마다 객체가 새롭게 나옴.
	}
}

