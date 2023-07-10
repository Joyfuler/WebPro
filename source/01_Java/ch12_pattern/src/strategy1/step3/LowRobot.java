package strategy1.step3;

// 액션, 건, 등..
public class LowRobot extends Robot {
	
	@Override
	public void actionFly() {
		System.out.println("날 수 없습니다.");
	}

	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없습니다.");
	}

	@Override
	public void actionKnife() {
		System.out.println("무기가 없습니다.");
	}
}
