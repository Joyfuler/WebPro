package strategy1.step4.modularization;

// import할 양이 많으므로 *을 설정. 혹은 컨+쉬프트+o로 필요한 인터페이스를 import할 수도 있음.
import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeLaser;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

// 슈퍼로봇클래스는 robot의 상속을 받았으므로, actionwalk(), actionrun(), shape() 존재함
public class SuperRobot extends Robot {

	// private FlyImpl fly = new FlyYes(); // 날 수 있다는 내용의 객체를 가진 fly 변수를 생성.
	// 단, 다른 것들이 사용하기 어려우니 FlyImpl로 이름을 변경

	// private MissileImpl missile = new MissileYes();
	// private KnifeImpl knife = new KnifeLaser();
	// 그러나 객체를 만들기만 하고, 생성자 함수에서 객체를 재정의해주는 것이 중요.

	private FlyImpl fly; // 1) 먼저 인터페이스에 대응하는 객체를 만들어줌.
	private MissileImpl missile;
	private KnifeImpl knife;

	public SuperRobot() { // 생성자 함수(메소드)
		// i= 10; 을 하거나, setI(10) 을 해도 똑같이 10이 대입되는 것처럼 변형할 것.
		setFly(new FlyYes()); // fly=a, 대신, setfly(a)와 같이 메소드를 대입해도 동일하게 작용함.
		// fly = new FlyYes();
		setMissile(new MissileYes());
		// missile = new MissileYes();
		setKnife(new KnifeLaser());
		// knife = new KnifeLaser();

		// 바꿔 낄 부품의 변수를 먼저 생성하고, 이후 변수를 set하는 과정이 필요함.
	}

	@Override
	public void actionFly() {
		fly.fly(); // fly라는 변수는 Flyyes. 그것의 fly 메소드 (날 수 있습니다) 실행.

		// 날 수 있으므로 flyyes객체를 만들어 줄 것.
	}

	@Override
	public void actionMissile() {
		missile.missile(); // missile에 연동되어 있는 missileyes로 가서, missile (미사일을 쏠 수 있다) 메소드를 실행.
	}

	@Override
	public void actionKnife() {
		knife.knife(); // knife에 연동되어 있는 KnifeLaser로 가서, knife 메소드를 실행함.
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
