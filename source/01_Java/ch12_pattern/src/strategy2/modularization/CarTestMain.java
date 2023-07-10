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
			// ���� ��û���� Ư�� �κи� ���̺긮��� �����ϰ� �ʹٸ�?
		}
		System.out.println("�ҳ�Ÿ�� ���Ḧ ���̺긮��, ���� 20ų�η� ���׷��̵��ش޶�� �Ѵٸ�?");
		cars[2].setFuel(new FuelHybrid()); // for�� ����� �迭������ �����Ƿ� �迭�� ��ġ�� ���� �����Ͽ� ���.
		cars[2].setKm(new Km20()); // ������ �̸� �������� �ʾ����Ƿ�, Sonata.setKm() ������δ� ��� �Ұ���.
		

	}
}
		
	

