package com.lec.ex1_string;

import java.util.StringTokenizer;

// 사람들의 리스트를 받고 싶을 때. 그런데 사람 수가 변수 안에 다 들어가 있는 경우?
public class Ex08_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "박보검 설현 수지 고소영 장동건"; // 구분자가 스페이스인 경우.
		String str2 = "100, 99, 85, 73"; // 콤마단위로 데이터가 변경되는 경우. 즉 구분자가 존재하는 경우
		StringTokenizer token1 = new StringTokenizer(str1);  
		//str1의 토큰을 설정. 아무것도 입력 안하는 경우 기본적으로 스페이스 구분자.
		StringTokenizer token2 = new StringTokenizer(str2, ", "); 
		//str2의 토큰을 설정. 콤마인지, 콤마 스페이스인지 주의!
		while(token1.hasMoreTokens()) { // hasmoretokens?! 해당 데이터 구분자의 다음 '토큰'으로 가는 명령어. true로 반환
										// 값의 마지막까지 가는 경우 false가 됨.
			System.out.println(token1.nextToken()); // 다음 토큰을 소환.
		} 
		System.out.println("------------------");
		
		while(token2.hasMoreElements()) {
			System.out.println(token2.nextElement()); // hasmoretoken = hasmoreelements. 
		}
		
	}
}
