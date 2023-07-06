package com.lec.ex10_final;

// 슈퍼클래스에 든 정보 = speed, running() 메소드, stop() 메소드, 단 final이므로 오버라이드 금지.
public class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("강아지가 꼬리를 흔들며 뛰어요. 현재 속도 : " + speed);
		
	}

}
