package strategy2.modularization;

import strategy2.interfaces.*;

public class Accent extends Car { // car�� ��ӹ��� ��, �׼�Ʈ���� ��ǰ�� ��������.

	public Accent() { 
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel()); // ��������, ����20, ���������� ���� set����.
	}

	@Override
	public void shape() { // �θ��� car���� shape�� �߻�Ŭ�����̹Ƿ� �׼�Ʈ�� �°� �߰�.
		System.out.println("����Ʈ ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�.");

	}

}
