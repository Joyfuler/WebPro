package com.lec.ex6_wrapper;
// 문자열 ("100")을 정수 100으로 바꾸는 방법. 
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("스트링을 정수로 전환");
		int i = Integer.parseInt("100");
		System.out.println("i = " + i);
		
		System.out.println("정수를 스트링으로 전환");
		String monthStr = String.valueOf(30);
		System.out.println(monthStr);
		

		
		
	}
	
}
