package com.lec.ex3_square;
 // 속성변수, 인스턴스 변수 등 + 생성자 + 메소드 + setter(값초기화) getter(값가져옴)
 // 메인에서 Square s = new Square(){ 식으로 만들거나 --> 생성자
 // Square s = new Square(1){ 식으로 만들어야 함 --> setter getter 

public class Square {
		private int side;
		public Square() { // 매개변수가 없을 때 디폴트 생성자. (클래스 이름과 동일하게 만들어야함)
			System.out.println("(매개 변수가 없는 생성자 함수 호출)");
		}
		public Square (int side) {
		this.side = side; // side라는 1개의 함수의 값을 초기화하는 메소드
		System.out.println("매개변수가 있는 생성자 함수 호출");
		}
		
		public int area() {
		return side * side; // 정사각형의 넓이를 구하는 메소드 area	
		}
		
		public void setSide (int side) {
			this.side = side;
					
		}
		public int getSide() {
			return side;
		}
			
	
}
