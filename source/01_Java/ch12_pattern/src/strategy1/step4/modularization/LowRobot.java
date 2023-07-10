package strategy1.step4.modularization;

import strategy1.step4.interfaces.*;

// �׼�, ��, ��..
public class LowRobot extends Robot {

	// 1. �������̽� �����ϴ� ���� 3�� �����. 2. Lowrobot�� �����ڸ� �����. 3. set�� ���� 3������ �ٽ� �������ش�. 4.
	// �� �޼ҵ忡 ��½����ش�.

	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife; // 

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo()); //�����ڿ��� ��ǰ�� �������� �������ĸ� �ٸ�.

	}

	@Override
	public void actionFly() {
		fly.fly(); // fly.fly; �ƴ�!! fly�� flyimpl�� �ִ� fly �޼ҵ带 �θ� ����.
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
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
