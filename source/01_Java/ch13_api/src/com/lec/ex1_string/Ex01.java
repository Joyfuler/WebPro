package com.lec.ex1_string;

public class Ex01 {
	public static void main(String[] args) {
		
	
	int i =10;
	String str1 = "Java"; // Java는 상수 풀?!
	String str2 = "Java"; // str2는 새롭게 변수를 생성한 것이 아님. str1이 가르켰던 것을 str2이 같이 가리키는 것.
						// str1에서 이미 생성이 되었고, str2는 동일한 주소를 가리키기만 하는 것임.
	String str3 = new String("Java"); // 만들어졌을 때 다음과 같이 안 해도 되도록 허용됨.
										
	if (str1 == str2) {
		System.out.println("str1과 str2는 같은 주소를 참조");
	} else {
		System.out.println("str1과 str2는 다른 주소를 참조");
	}
	System.out.println(str1 == str3 ? "같은 주소" : "다른 주소"); // 분명 같은 값인데도 주소가 다름. new로 새롭게 만들어졌기 때문.
	str2 = "Oracle"; // str2를 java에서 oracle로 바꾼다면? 기존 주소를 버리고 oracle에 대응하는 메모리를 생성.
	if (str1 == str2) {
		System.out.println("수정후, str1과 str2는 같은 주소를 참조");
	} else {
		System.out.println("수정후, str1과 str2는 다른 주소를 참조");
	}
	
	// 하지만 equals로 비교한다면?
	
	
	
	
	}
}
