package strategy1.step2;

// 액션, 건, 등..
public class StandardRobot extends Robot {
	public void actionFly() {
		System.out.println("날 수 없습니다.");
	}

	public void actionMissile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}

	public void actionKnife() {
		System.out.println("목검을 사용합니다.");
	}
}
