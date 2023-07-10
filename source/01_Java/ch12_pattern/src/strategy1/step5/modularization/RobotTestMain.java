package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.KnifeToy;

public class RobotTestMain {
	public static void main(String[] args) {
		Robot superRobot = new SuperRobot();
		Robot standardRobot = new StandardRobot();
		Robot lowRobot = new LowRobot();
		Robot[] robots = { superRobot, standardRobot, lowRobot };
		for (Robot robotarray : robots) {
			robotarray.shape();
			robotarray.actionRun();
			robotarray.actionWalk();
			robotarray.actionFly();
			robotarray.actionMissile();
			robotarray.actionKnife();
		} // for
		System.out.println("SuperRobot이 높이, 아주 높이 날 수 있는 기능으로 업그레이드");
		// 기존 소스를 건들지 않고 기능을 추가하는 방법... 기존 소스 건들다가 연동된 다른 기능에 문제가 생기지 않도록
		superRobot.setFly(new FlyHigh()); // 변수에 setfly를 통해 신기능을 추가.
		superRobot.actionFly();
		System.out.println("LowRobot의 장난감 검이 있는 기능으로 업그레이드"); // 두개 하고 싶은데 추가해줘요~
		lowRobot.setKnife(new KnifeToy()); // 기능 업그레이드(set)는 명령어의 가장 앞으로 둘 것!
		lowRobot.actionKnife(); // 이후 actionknife를 통해 앞에 (set)한 것을 출력해 주면 끝!

	} // if

// 추상 클래스 생성, 오버라이드 시킨 후 훨씬 더 간단하게 제작이 가능함.			

} // main
// class
