package strategy2.modularization;

import strategy2.interfaces.*;

public class Genesis extends Car {

	public Genesis() {
	setEngine(new EngineHigh());
	setKm(new Km10());
	setFuel(new FuelGasoline()); // ���׽ý��� ��ǰ�� ����.
	}
	
	
	@Override
	public void shape() {
		System.out.println("���׽ý� ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�.");

	}

}
