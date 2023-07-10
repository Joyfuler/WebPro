package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyNo;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

// 액션, 건, 등..
public class LowRobot extends Robot {

	// 1. 인터페이스 대응하는 변수 3개 만든다. 2. Lowrobot의 생성자를 만든다. 3. set를 통해 3가지를 다시 정의해준다. 4.
	// 각 메소드에 출력시켜준다.

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo()); // 생성자에서 부품을 무엇으로 끼웠느냐만 다름.

	}
// 이전에 있던 오버라이드와 get 메소드를 전부 날려버려도 무사히 구동가능.
}
