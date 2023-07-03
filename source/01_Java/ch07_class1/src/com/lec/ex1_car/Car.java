package com.lec.ex1_car;
 // 클래스 --> 객체 생성 (객체 안에는 데이터와 메소드가 함께 있음) Car car = new Car ();
public class Car { // 
	private String color; // 컬러라는 변수 생성
	private int cc; // 배기량 변수 생성
	private int speed; // 현재 속도 변수 생성 //
	// 3개의 데이터를 생성한 것. 이후 private를 넣어 외부에서 데이터를 바꾸지 못하게 만듬.
	
	public void park() { // 주차기능
		speed = 0;
		System.out.println(color + "색 차 주차함. 지금 속도는 " + speed);
		// 다른 곳에서 car.park(); 입력시 스피드는 0 상태의 본 메소드 출력
	}
	
	public void drive() { // 주행중일때의 메소드를 생성
		speed = 60;
		System.out.println(color + "색 차 운행중. 지금 속도는 " + speed);
	}
	
	public void race() { //주차 기능
		speed = 120;
		System.out.println(color + "색 차 레이스. 지금 속도는 " + speed);
	}
		// 데이터를 먼저 넣고, 그 후 기능(스피드 변수 조정, 출력)하는 함수도 함께 넣었음.
		
		// color, cc, speed에 모두 private를 넣어서 다른 클래스에서 사용하지 못하게 되어버림. 이 때 setter & getter 메소드가 필요함.
	public void setColor(String color) {
		this.color = color; // (this를 넣어 매개변수로 넣은 color를 객체에 있는 color로 넣게 함. (color가 중복되어 있기 때문)
		
	}
	public String getColor() {// 이후 getter 메소드를 넣어줌.	
		return color;
		
	}	
	
	
	public void setCc (int cc) {
		this.cc = cc; // (마찬가지로 매개변수 cc를 객체에 있는 cc로 넣게 해줌.)
		
	}

	public int getCc() {
		return cc;
	
	
	}
	
	public void setSpeed (int speed) {
		this.speed = speed;
	}
	
	public int getSpeed () {
		return speed;
	}
}
