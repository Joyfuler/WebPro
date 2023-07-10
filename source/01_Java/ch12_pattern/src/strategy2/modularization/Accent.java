package strategy2.modularization;

import strategy2.interfaces.*;

public class Accent extends Car { // car을 상속받은 뒤, 액센트만의 부품을 설정해줌.

	public Accent() { 
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel()); // 저질엔진, 연비20, 디젤연료라는 것을 set해줌.
	}

	@Override
	public void shape() { // 부모인 car에서 shape가 추상클래스이므로 액센트에 맞게 추가.
		System.out.println("엑센트 차량은 문, 시트, 핸들로 이루어져 있습니다.");

	}

}
