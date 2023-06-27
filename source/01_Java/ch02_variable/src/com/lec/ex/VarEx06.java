package com.lec.ex;

//기본데이터타입 (기초데이터타입 - 소문자시작 ) VS. 참조데이터타입( 객체데이터타입 - 대문자시작)

public class VarEx06 {
public static void main(String[] args) {
	//	기본데이터타입
	int i; // i에 int를 잡아줌 = 4바이트. 값이 없는 i가 나옴 -> 변수 안에 데이터를 넣는 개념
	i = 10; // i에 10을 대입
	
	//  참조데이터타입 (객체데이터타입)
	
	String name; 
	name = "kim"; // 3바이트 필요
	name = "김수한무 거북이와 두루미 삼천갑자"; // 바이트 무관. 해당 데이터가 있는 번지수를 참조하는 것.
									// 변수 주머니 안에 들어가는 것이 아님! tainanjiele...
	System.out.println("name = " + name);
	

}
		
	}


