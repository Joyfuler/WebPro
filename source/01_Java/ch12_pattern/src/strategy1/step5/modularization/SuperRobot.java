package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeLaser;
import strategy1.step4.interfaces.MissileYes;

// ���۷κ�Ŭ������ robot�� ����� �޾����Ƿ�, actionwalk(), actionrun(), shape() ������
public class SuperRobot extends Robot {

	// private FlyImpl fly = new FlyYes(); // �� �� �ִٴ� ������ ��ü�� ���� fly ������ ����.
	// ��, �ٸ� �͵��� ����ϱ� ������ FlyImpl�� �̸��� ����

	// private MissileImpl missile = new MissileYes();
	// private KnifeImpl knife = new KnifeLaser();
	// �׷��� ��ü�� ����⸸ �ϰ�, ������ �Լ����� ��ü�� ���������ִ� ���� �߿�.

	public SuperRobot() { // ������ �Լ�(�޼ҵ�)
		// i= 10; �� �ϰų�, setI(10) �� �ص� �Ȱ��� 10�� ���ԵǴ� ��ó�� ������ ��.
		setFly(new FlyYes()); // fly=a, ���, setfly(a)�� ���� �޼ҵ带 �����ص� �����ϰ� �ۿ���.
		// fly = new FlyYes();
		setMissile(new MissileYes());
		// missile = new MissileYes();
		setKnife(new KnifeLaser());
		// knife = new KnifeLaser();

		// �ٲ� �� ��ǰ�� ������ ���� �����ϰ�, ���� ������ set�ϴ� ������ �ʿ���.
	}

}
