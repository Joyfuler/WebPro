package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeWooden;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

// 액션, 건, 등..
public class StandardRobot extends Robot {

	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public StandardRobot() {
		// fly = new FlyNo(); 대신 set을 이용.
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWooden()); //생성자에서 부품을 무엇으로 끼웠느냐만 다름.

	}

	@Override
	public void actionFly() {
		fly.fly();
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
