package strategy1.step4.modularization;

// import�� ���� �����Ƿ� *�� ����. Ȥ�� ��+����Ʈ+o�� �ʿ��� �������̽��� import�� ���� ����.
import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeLaser;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

// ���۷κ�Ŭ������ robot�� ����� �޾����Ƿ�, actionwalk(), actionrun(), shape() ������
public class SuperRobot extends Robot {

	// private FlyImpl fly = new FlyYes(); // �� �� �ִٴ� ������ ��ü�� ���� fly ������ ����.
	// ��, �ٸ� �͵��� ����ϱ� ������ FlyImpl�� �̸��� ����

	// private MissileImpl missile = new MissileYes();
	// private KnifeImpl knife = new KnifeLaser();
	// �׷��� ��ü�� ����⸸ �ϰ�, ������ �Լ����� ��ü�� ���������ִ� ���� �߿�.

	private FlyImpl fly; // 1) ���� �������̽��� �����ϴ� ��ü�� �������.
	private MissileImpl missile;
	private KnifeImpl knife;

	public SuperRobot() { // ������ �Լ�(�޼ҵ�)
		// i= 10; �� �ϰų�, setI(10) �� �ص� �Ȱ��� 10�� ���ԵǴ� ��ó�� ������ ��.
		setFly(new FlyYes()); // fly=a, ���, setfly(a)�� ���� �޼ҵ带 �����ص� �����ϰ� �ۿ���.
		// fly = new FlyYes();
		setMissile(new MissileYes());
		// missile = new MissileYes();
		setKnife(new KnifeLaser());
		// knife = new KnifeLaser();

		// �ٲ� �� ��ǰ�� ������ ���� �����ϰ�, ���� ������ set�ϴ� ������ �ʿ���.
	}

	@Override
	public void actionFly() {
		fly.fly(); // fly��� ������ Flyyes. �װ��� fly �޼ҵ� (�� �� �ֽ��ϴ�) ����.

		// �� �� �����Ƿ� flyyes��ü�� ����� �� ��.
	}

	@Override
	public void actionMissile() {
		missile.missile(); // missile�� �����Ǿ� �ִ� missileyes�� ����, missile (�̻����� �� �� �ִ�) �޼ҵ带 ����.
	}

	@Override
	public void actionKnife() {
		knife.knife(); // knife�� �����Ǿ� �ִ� KnifeLaser�� ����, knife �޼ҵ带 ������.
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
