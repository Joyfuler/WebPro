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
			if (robotarray instanceof SuperRobot) { // �� �� �迭 �ӿ� �ִ� ���� Superrobot�� ��ü�� �ִٸ�?
				SuperRobot temp = (SuperRobot) robotarray; // temp��� �ӽ� ������ �����Ͽ� ����ȯ.
														// �� �κ����� ����ȯ�� ������ �� ����� ���.
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

//			((SuperRobot)robotarray).actionFly(); // ����ȯ�� �ϵ�, ���� �ݵ�� Ȯ���� ��.
		} // for

	} // main
} // class
