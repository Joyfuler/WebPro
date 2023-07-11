package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.MissileImpl;

public abstract class Robot {
// 로봇 모두가 공통적으로 가진 기능. 모양, 걷고 뛰고...
	
	
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife; //각 로봇에 있던 공통된 변수(부품) 설정. 아예 상위 클래스로 올리면 더욱 타이핑이 줄어듬!
	
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}

	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}

	public void shape() { // 슈퍼로봇이면? (무슨무슨) Robot은 팔, 다리, 몸통, 머리가 있습니다.
		String className = getClass().getName(); // 클래스에서 이름을 가져오는 명령어.
		// getclass(). getname()... 해당 클래스의 이름이 classname이라는 변수에 대입됨.
		// 클래스네임은 strategy1.step2.SuperRobot...
		int idx = className.lastIndexOf("."); // 맨 마지막에 나오는 "." 의 위치를 idx로.
		//
		String name = className.substring(idx + 1); // 16번째부터 끄까지 문자열을 추출..
		// 즉 name은 마지막 . 뒤에 있는 글자를 추출한 SuperRobot이 됨.
		System.out.println(name + "의 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}
	
	public void actionFly() { //추상클래스였던 3가지를 모두 구현시킴. abstract 삭제, fly.fly() ... 추가
		fly.fly();
	}
	public void actionMissile(){
		missile.missile();
	}
	public void actionKnife() {
		knife.knife();
	}
	

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
	
	
	
	
}
