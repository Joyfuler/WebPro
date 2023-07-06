package com.lec.ex10_final;
// speed, runnning(), stop(). stop은 오버라이드x
public final class Rabbit extends Animal { // final class 선언. 이후 rabbit을 다른 곳에 상속할 수는 없음.
	@Override
	public void running() {
		speed += 30;
		System.out.println("토끼가 깡총깡총 뛰어요. 현재 속도: " + speed);
	}
	
	
}
