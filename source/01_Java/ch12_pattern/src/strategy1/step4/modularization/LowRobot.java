package strategy1.step4.modularization;

import strategy1.step4.interfaces.*;

// 액션, 건, 등..
public class LowRobot extends Robot {

	// 1. 인터페이스 대응하는 변수 3개 만든다. 2. Lowrobot의 생성자를 만든다. 3. set를 통해 3가지를 다시 정의해준다. 4.
	// 각 메소드에 출력시켜준다.

	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife; // 

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo()); //생성자에서 부품을 무엇으로 끼웠느냐만 다름.

	}

	@Override
	public void actionFly() {
		fly.fly(); // fly.fly; 아님!! fly는 flyimpl에 있는 fly 메소드를 부른 것임.
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
