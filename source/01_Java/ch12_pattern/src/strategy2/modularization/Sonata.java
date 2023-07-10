package strategy2.modularization;

import strategy2.interfaces.*;

public class Sonata extends Car {

	public Sonata() {
		setEngine(new EngineMid());
		setFuel(new FuelGasoline());
		setKm(new Km15());
	}

	@Override
	public void shape() {
		System.out.println("소나타 차량은 문, 시트, 핸들로 이루어져 있습니다.");

	}

}
