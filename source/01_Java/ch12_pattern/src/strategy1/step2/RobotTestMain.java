package strategy1.step2;

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
			if (robotarray instanceof SuperRobot) { // ★ 이 배열 속에 있는 것중 Superrobot의 객체가 있다면?
				SuperRobot temp = (SuperRobot) robotarray; // temp라는 임시 변수를 생성하여 형변환.
														// 각 로봇마다 형변환을 진행한 후 기능을 출력.
				temp.actionFly();
				temp.actionMissile();
				temp.actionKnife();
			} else if (robotarray instanceof StandardRobot) {
				StandardRobot temp = (StandardRobot) robotarray;
				temp.actionFly();
				temp.actionMissile();
				temp.actionKnife();
			} else if (robotarray instanceof LowRobot) {
				LowRobot temp = (LowRobot) robotarray;
				temp.actionFly();
				temp.actionMissile();
				temp.actionKnife();

			} // if

//			((SuperRobot)robotarray).actionFly(); // 형변환을 하되, 먼저 반드시 확인할 것.
		} // for

	} // main
} // class
