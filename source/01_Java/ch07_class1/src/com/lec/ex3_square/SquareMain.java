package com.lec.ex3_square;

public class SquareMain {
	public static void main(String[] args) {
		// s1.setSide // getSide
	
		Square s1 = new Square(); // 매개변수가 없는 생성자 함수 호출 --> 기본 생성자이기 떄문.
		System.out.println("s1의 한 변 길이는 " + s1.getSide()); // 0으로 초기화되어 있으므로 0이 나옴.
		System.out.println("s1의 넓이는" + s1.area());
		
		
		Square s2 = new Square(10); // side가 10으로 초기화된 s2 변수를 호출. --> side 매개변수가 들어간 Square 메소드를 불러옴.
		System.out.println("s2의 한 변 길이는 " + s2.getSide());
		System.out.println("s2의 넓이는 " + s2.area());
		
		
		s1.setSide(5);
		System.out.println("새로 넣은 side 값은 " + s1.getSide());
		System.out.println("5의 길이를 가진 정사각형의 넓이: " + s1.area());
		
		
	} 
}
