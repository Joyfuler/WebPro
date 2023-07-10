package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeWooden;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

// �׼�, ��, ��..
public class StandardRobot extends Robot {

	public StandardRobot() {
		// fly = new FlyNo(); ��� set�� �̿�.
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWooden()); // �����ڿ��� ��ǰ�� �������� �������ĸ� �ٸ�.

	}

}
