package com.lec.ex10_final;
// speed, running(), stop() 을 dog에서 받음. running()은 dog에서 오버라이드한 speed +=10 을 받음. stop은 여전히 오버라이드 금지.
public class BlueDog extends Dog {
	@Override
	public void running() {
		speed += 10;
		System.out.println("파란 강아지가 꼬리를 흔들며 뛰어요. 현재 속도 : " + speed);
}
}
