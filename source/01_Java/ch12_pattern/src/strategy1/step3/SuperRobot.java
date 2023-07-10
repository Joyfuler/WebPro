package strategy1.step3;

// 슈퍼로봇클래스는 robot의 상속을 받았으므로, actionwalk(), actionrun(), shape() 존재함
public class SuperRobot extends Robot {
	
	@Override
	public void actionFly() {
		System.out.println("날 수 있습니다.");
	}

	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}

	@Override
	public void actionKnife() {
		System.out.println("레이저 검을 사용합니다.");
	}
}
