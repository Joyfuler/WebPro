package com.lec.ex;
 // 동등 (비교) 연산자: == != (다르다라는 의미),  > < >= <=
public class Ex03 {
	public static void main(String[] args) {
		int n1= 10, n2 = 15;
		boolean result = (n1 == n2);
		System.out.println(result + "\n");
		System.out.printf("%d %s %d 는 %b\n", n1, "==", n2, result);
		result = (n1 != n2);
		System.out.printf("%d %s %d 는 %b\n", n1, "!=", n2, result);
		result = (n1 >=	n2);
		System.out.printf("%d %s %d 는 %b\n", n1, ">=", n2, result);
		result = (n1 <= n2);
		System.out.printf("%d %s %d는 %b\n", n1, "<=", n2, result);
		result = !(n1 != n2);
		System.out.printf("%d %s %d는 %b\n", n1, "!=", n2, result); // !는 반대로 출력.
		// 
	}

}
