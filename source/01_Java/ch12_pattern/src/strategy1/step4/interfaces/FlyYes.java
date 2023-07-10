package strategy1.step4.interfaces;

public class FlyYes implements FlyImpl { // 클래스 자체가 날 수 있습니다를 출력하도록..

	@Override
	public void fly() {
		System.out.println("날 수 있습니다.");

	}

}
