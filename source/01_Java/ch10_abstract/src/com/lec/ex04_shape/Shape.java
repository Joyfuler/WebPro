package com.lec.ex04_shape;

public abstract class Shape { // 오류 발생. abstract 넣을것
// 원, 사각형, 삼각형... 공통된 데이터가 없는 경우?
// 넓이를 계산하는 area
	public abstract double area(); // 넓이를 return할 추상메소드를 선언. 차후 상속시 오버라이드강제
	public void draw() {
		System.out.println(" 도형을 그려요");
	}
}
