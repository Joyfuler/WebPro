package com.lec.ex03_point.copy;
// 2차원 좌표값
public class Point {
	private int x;
	private int y;
	
	public Point() { // 필수적으로 매개변수x 생성자 먼저 생성!
		System.out.println("매개변수가 없는 부모클래스 생성자 함수");
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("매개변수 2개가 있는 부모클래스 생성자 함수 - x,y 초기화");
	}
	
	public void infoPrint() {
		System.out.println("좌표값 : x = " + x + ", y = " + y);
	}

	public int getX() { // x,y가 모두 private이므로 외부에서 넣거나 사용할 수 있도록 get,set을 마련해둠.
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
