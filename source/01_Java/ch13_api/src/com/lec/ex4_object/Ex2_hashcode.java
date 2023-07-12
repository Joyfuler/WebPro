package com.lec.ex4_object;

public class Ex2_hashcode {
	public static void main(String[] args) {
		String str1 = "Hello"; // 기존 메모리 중 Hello가 있는지를 탐색함. 없는 경우 새로 생성
		String str2 = new String("Hello"); // 무조건 새로운 개체를 만듬. 따라서 str1과 str2의 주소는 다름.
		if (str1 == str2) { // 당연히 다르지만)
			System.out.println("주소가 같은 곳을 참조함.");
		} else {
			System.out.println("주소가 다른 곳을 참조함.");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode()); // 같은 값이면 해시코드는 동일하나, 그 주소는 다름.

		if (str1.equals(str2)) {
			System.out.println("같은 문자열");
			System.out.println(str1.hashCode());
			System.out.println(str2.hashCode()); // 주소는달라! 문자열만 같다는 의미
		}
	}
}
