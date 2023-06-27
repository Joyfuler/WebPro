package com.lec.ex;

// 할당 연산자 : =, +=, -=, *=, /=, %= 도 존재
public class Ex06 {
	public static void main(String[] args) {
		int n1= 10;
		n1 += 10; // n1 = n1 + 10과 동일. 왼쪽 n1에 본래 n1 + 10을 대입  -> 20
		System.out.println("n1 = " + n1);
		// 일반적으로 1개씩 증가하는 경우 n1++, ++n1을 사용하고, 여러개씩 증가하는 경우는 n1 += 10 등을 사용함.
		n1 *= 2; // n1 = n1 * 2 / 20 * 2 = 40
		System.out.println("n1 =" + n1);
		
		int n2, n3;
		n1 = n2 = n3 = 10; // = 인 경우 뒤부터 계산. n3=10 -> n2 = 10 -> n1= 10 순서.
		System.out.println(n1 + "\t" + n2 + "\t" + n3);
		
		
	}
}
