package com.lec.ex10_final;

public class Animal {
	protected int speed;
	public void running() {
	speed += 5; // running 할 때마다 스피드가 5씩 증가함.
	System.out.println("동물이 뛰고 있어요. 현재 속도 :" + speed); // running할 때마다 speed가 증가하는 상태로 출력됨.
	
	}
	public final void stop() { // final이 붙었으므로 stop은 오버라이드가 금지됨.
		speed = 0;
		System.out.println("멈춤!");
	}
		
}
