package strategy2.modularization;
// 속성변수 - 생성자 - 메소드 (일반메소드 - 오버라이드한 메소드 - setter getter 설정 순서로 진행할 것. 오버라이드와 게터세터는 마지막에.

import strategy2.interfaces.Engineimpl;
import strategy2.interfaces.FuelImpl;
import strategy2.interfaces.KmImpl;

public abstract class Car {
	private Engineimpl engine; // engineimpl 타입의 변수생성.
	private FuelImpl fuel;
	private KmImpl km; // 각 부품의 타입을 완성함.
	
	// 생성자는 스킵. 이후 공통되는 메소드를 만들어줌.
	
	public void drive () {
		System.out.println("운전을 할 수 있습니다.");
	}
	
	public abstract void shape(); // 모양은 차종마다 다르므로 추상클래스로 설정. 이후 클래스인 car 앞에도 abstract 추가
	public void isEngine() {
		engine.engine(); // 이후 각 클래스에서 설정한 값에 맞춰 출력됨.
	}
	public void isKmperLiter() {
		km.kmPerLiter();
	}
	public void isFuel() {
		fuel.fuel();
	}
	
	// 이후 getset 생성
	

	public Engineimpl getEngine() {
		return engine;
	}

	public void setEngine(Engineimpl engine) {
		this.engine = engine;
	}

	public FuelImpl getFuel() {
		return fuel;
	}

	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}

	public KmImpl getKm() {
		return km;
	}

	public void setKm(KmImpl km) {
		this.km = km;
	}
	
	
	
	
	
}
