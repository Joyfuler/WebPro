package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str4 = new String("abcXabc"); // 위와 수는 같으나 주소가 다름. new로 생성
		String str2 = "         Ja va          ";
		System.out.println("1."+ str1.concat("AAA")); // concat은 두 문자를 합하는 것. abcXabc와 AAA를 합함.
		System.out.println("2." + str1.substring(3)); //문자열 추출. 시작, 마지막. 3만 입력시 3번째 글자부터 마지막까지추출
		System.out.println("3." + str1.substring(3, 5)); // 3번째부터 5번째 '앞까지' --> Xa (string반환)
		System.out.println("4." + str1.length()); // 문자열의 길이 = 7 (0부터 6까지)
		System.out.println("5." + str1.toUpperCase()); // 모두 대문자로. ABCXABC
		System.out.println("6." + str1.toLowerCase()); // 모두 소문자로. abcxabc
		System.out.println("7." + str1.charAt(3)); // 3번째 글자만 가져오는 것. (char반환)
		System.out.println("8." + str1.indexOf('b')); // 해당 글자가 '처음' 있는 곳의 위치를 찾아줌. 1
		System.out.println("9." + str1.lastIndexOf('b')); // 해당 글자가 '마지막' 나온 곳의 위치를 찾아줌. 5
		System.out.println("10." + str1.indexOf('@')); //없는 경우, -1로 리턴됨. --> 차후 유효성 검사에 사용.
		System.out.println("11." + str1.indexOf("Xabc")); // 문자를 여러개 입력해도 무방. 시작 위치
		String str3 = "abcXabcXabc"; // b가 3개 있을 때, 가운데 b를 찾는 방법은?
		System.out.println("12." + str3.indexOf("bc", 6)); // 2번째 위치부터 시작하는 b를 찾는 방법.
		System.out.println("13." + str4.equals(str1)); // 같은 주소값 x, 같은 스펠링인지 물어봄. true
														// str1 == str4로 묻는 경우는 false
		System.out.println("14." + str4.equalsIgnoreCase("ABCXABC")); // 대소문자 구분없이
		System.out.println("15." + str2.trim()); // 앞뒤의 스페이스를 제거해줌. Ja va
		System.out.println("16." + str3.replace("abc", "바꿔")); // abc라는 문구를 모두 바꿔로 바꿈
		// 단, 해당 메소드의 결과만 반환하는 것이며, str 변수 자체의 값을 바꾸는 것은 아님.
		System.out.println("str1: " + str1);
	}
}
