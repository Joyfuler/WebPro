package strategy2.modularization;

import strategy2.interfaces.*;

public class Genesis extends Car {

	public Genesis() {
	setEngine(new EngineHigh());
	setKm(new Km10());
	setFuel(new FuelGasoline()); // 제네시스의 부품을 설정.
	}
	
	
	@Override
	public void shape() {
		System.out.println("제네시스 차량은 문, 시트, 핸들로 이루어져 있습니다.");

	}

}
