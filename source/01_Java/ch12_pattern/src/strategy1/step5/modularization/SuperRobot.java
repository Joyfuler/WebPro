package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeLaser;
import strategy1.step4.interfaces.MissileYes;

// 슈퍼로봇클래스는 robot의 상속을 받았으므로, actionwalk(), actionrun(), shape() 존재함
public class SuperRobot extends Robot {

	// private FlyImpl fly = new FlyYes(); // 날 수 있다는 내용의 객체를 가진 fly 변수를 생성.
	// 단, 다른 것들이 사용하기 어려우니 FlyImpl로 이름을 변경

	// private MissileImpl missile = new MissileYes();
	// private KnifeImpl knife = new KnifeLaser();
	// 그러나 객체를 만들기만 하고, 생성자 함수에서 객체를 재정의해주는 것이 중요.

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

}
