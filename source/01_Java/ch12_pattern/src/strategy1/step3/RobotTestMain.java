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

// �߻� Ŭ���� ����, �������̵� ��Ų �� �ξ� �� �����ϰ� ������ ������.			
		

	} // main
// class
