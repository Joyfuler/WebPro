package com.lec.ex04_shape;
import cons.Constant;

public class Circle extends Shape {

	private int r; // 반지름 r
		
	
	public Circle() {

	}

	public Circle(int r) {
	  this.r = r;
	}



	@Override
	public double area() {
		return Constant.PI * r * r;
	}
	
	@Override
	public void draw() {
	System.out.print("원");
		super.draw(); // 원 도형을 그려요
	}

}
