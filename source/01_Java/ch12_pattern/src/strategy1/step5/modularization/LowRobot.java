package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

// �׼�, ��, ��..
public class LowRobot extends Robot {

	// 1. �������̽� �����ϴ� ���� 3�� �����. 2. Lowrobot�� �����ڸ� �����. 3. set�� ���� 3������ �ٽ� �������ش�. 4.
	// �� �޼ҵ忡 ��½����ش�.

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo()); // �����ڿ��� ��ǰ�� �������� �������ĸ� �ٸ�.

	}
// ������ �ִ� �������̵�� get �޼ҵ带 ���� ���������� ������ ��������.
}
