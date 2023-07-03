package com.lec.ex2_rect;
// 클래스 : 속성 (데이터, 인스턴스 변수), 메소드 (public), setter&getter) 
public class Rect { // 클래스명은 반드시 대문자. 변수는 소문자로.. 식별자: 알파벳, 언더바, 숫자로. 또한 알파벳으로 시작해야 함.)
	private int width; // private 넓이변수
	private int height; // 높이변수
	
	// 생성자 함수 추가 무조건 public, class 이름과 동일.
	public Rect() {} //기본 생성자 함수. (생성자 함수가 없는 경우 자동생성)
	
	public Rect (int width, int height){ // 매개변수를 2개 넣은 생성자를 만듬.
		this.width = width;
		this.height = height;
	}
	// return은 없이.
		
		
	public Rect (int side) { // 매개변수가 1개 있는 생성자.
	width = height = side; // side에 7을 넣고 높이와 넓이에 모두 7을 넣음. (정사각형)
	}
	
	
	
	
	
	
	public int area() { // 사각형의 넓이를 구하는 메소드(기능)
		return (width * height); // 높이와 넓이의 곱을 반환함.
		
	}
	// 세터게터
	
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	
	}
	public int getHeight() {
		return height;
	}
	
}
// 즉 설계도