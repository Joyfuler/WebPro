package strategy1.step3;

import javax.xml.transform.Templates;

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
		}
			} // if

// 추상 클래스 생성, 오버라이드 시킨 후 훨씬 더 간단하게 제작이 가능함.			
		

	} // main
// class
