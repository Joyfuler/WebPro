package strategy2.modularization;
// �Ӽ����� - ������ - �޼ҵ� (�Ϲݸ޼ҵ� - �������̵��� �޼ҵ� - setter getter ���� ������ ������ ��. �������̵�� ���ͼ��ʹ� ��������.

import strategy2.interfaces.Engineimpl;
import strategy2.interfaces.FuelImpl;
import strategy2.interfaces.KmImpl;

public abstract class Car {
	private Engineimpl engine; // engineimpl Ÿ���� ��������.
	private FuelImpl fuel;
	private KmImpl km; // �� ��ǰ�� Ÿ���� �ϼ���.
	
	// �����ڴ� ��ŵ. ���� ����Ǵ� �޼ҵ带 �������.
	
	public void drive () {
		System.out.println("������ �� �� �ֽ��ϴ�.");
	}
	
	public abstract void shape(); // ����� �������� �ٸ��Ƿ� �߻�Ŭ������ ����. ���� Ŭ������ car �տ��� abstract �߰�
	public void isEngine() {
		engine.engine(); // ���� �� Ŭ�������� ������ ���� ���� ��µ�.
	}
	public void isKmperLiter() {
		km.kmPerLiter();
	}
	public void isFuel() {
		fuel.fuel();
	}
	
	// ���� getset ����
	

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
