package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.MissileImpl;

public abstract class Robot {
// �κ� ��ΰ� ���������� ���� ���. ���, �Ȱ� �ٰ�...
	
	
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife; //�� �κ��� �ִ� ����� ����(��ǰ) ����. �ƿ� ���� Ŭ������ �ø��� ���� Ÿ������ �پ��!
	
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}

	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}

	public void shape() { // ���۷κ��̸�? (��������) Robot�� ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.
		String className = getClass().getName(); // Ŭ�������� �̸��� �������� ��ɾ�.
		// getclass(). getname()... �ش� Ŭ������ �̸��� classname�̶�� ������ ���Ե�.
		// Ŭ���������� strategy1.step2.SuperRobot...
		int idx = className.lastIndexOf("."); // �� �������� ������ "." �� ��ġ�� idx��.
		//
		String name = className.substring(idx + 1); // 16��°���� ������ ���ڿ��� ����..
		// �� name�� ������ . �ڿ� �ִ� ���ڸ� ������ SuperRobot�� ��.
		System.out.println(name + "�� ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
	
	public void actionFly() { //�߻�Ŭ�������� 3������ ��� ������Ŵ. abstract ����, fly.fly() ... �߰�
		fly.fly();
	}
	public void actionMissile(){
		missile.missile();
	}
	public void actionKnife() {
		knife.knife();
	}
	

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
	
	
	
	
}
