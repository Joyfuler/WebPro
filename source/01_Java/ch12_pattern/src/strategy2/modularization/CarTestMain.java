package strategy2.modularization;

import strategy2.interfaces.*;

public class CarTestMain {
	public static void main(String[] args) {
		Car[] cars = {new Accent(), new Genesis(), new Sonata()};
		for (int index = 0 ; index < cars.length; index++) {
			cars[index].shape();
			cars[index].drive();
			cars[index].isEngine();
			cars[index].isFuel();
			cars[index].isKmperLiter(); 
			// 고객의 요청으로 특정 부분만 하이브리드로 변경하고 싶다면?
		}
		System.out.println("소나타의 연료를 하이브리드, 연비를 20킬로로 업그레이드해달라고 한다면?");
		cars[2].setFuel(new FuelHybrid()); // for를 사용해 배열안으로 들어갔으므로 배열의 위치를 직접 지정하여 출력.
		cars[2].setKm(new Km20()); // 변수를 미리 설정하지 않았으므로, Sonata.setKm() 방식으로는 출력 불가능.
		

	}
}
		
	

