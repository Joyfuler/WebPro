package com.lec.ex04_shape;

public class Triangle extends Shape {
	private int w;
	private int h;

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double area() {
		return (w * h);
	}
@Override
public void draw() {
	System.out.print("»ç°¢Çü");
	super.draw();
}
}
