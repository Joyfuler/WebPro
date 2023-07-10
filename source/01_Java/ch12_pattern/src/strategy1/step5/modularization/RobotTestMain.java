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
		System.out.println("SuperRobot�� ����, ���� ���� �� �� �ִ� ������� ���׷��̵�");
		// ���� �ҽ��� �ǵ��� �ʰ� ����� �߰��ϴ� ���... ���� �ҽ� �ǵ�ٰ� ������ �ٸ� ��ɿ� ������ ������ �ʵ���
		superRobot.setFly(new FlyHigh()); // ������ setfly�� ���� �ű���� �߰�.
		superRobot.actionFly();
		System.out.println("LowRobot�� �峭�� ���� �ִ� ������� ���׷��̵�"); // �ΰ� �ϰ� ������ �߰������~
		lowRobot.setKnife(new KnifeToy()); // ��� ���׷��̵�(set)�� ��ɾ��� ���� ������ �� ��!
		lowRobot.actionKnife(); // ���� actionknife�� ���� �տ� (set)�� ���� ����� �ָ� ��!

	} // if

// �߻� Ŭ���� ����, �������̵� ��Ų �� �ξ� �� �����ϰ� ������ ������.			

} // main
// class
