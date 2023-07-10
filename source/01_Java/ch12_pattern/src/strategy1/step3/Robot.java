package strategy1.step3;

public abstract class Robot {
// �κ� ��ΰ� ���������� ���� ���. ���, �Ȱ� �ٰ�...
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
	public abstract void actionFly(); // �ݵ�� �������̵��ϱ� ���� �߻�Ŭ����. abstract�� �߰��� ��
	public abstract void actionMissile();
	public abstract void actionKnife();
	
	
}
