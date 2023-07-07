package com.lec.ex_03_speaktv;

public class Tv implements IVolume {

	
	private int volumeLevel;
	
	
	public Tv() {
		volumeLevel = 5; // tv�� �Ѹ� ������ �׻� 5�� �ʱ�ȭ��.
	}
	
	
	@Override
	public void volumeUp() {
		
		if (volumeLevel < IVolume.TV_MAX_VOLUME) { // IVolume�� �ִ� �ƽ����� ����� ��ȯ
		volumeLevel++;
		System.out.println("TV ������ 1��ŭ �÷� ���� ������" + volumeLevel);
		} else {
			System.out.println("TV ������ �ִ�ġ ( " + IVolume.TV_MAX_VOLUME + " ) �̹Ƿ� �ø��� ����");
		}									// public�̶�� IVolume�� ������� �ʾƵ� ����...
	}

	@Override
	public void volumeUp(int level) {

		if (volumeLevel + level < IVolume.TV_MAX_VOLUME) { // ���� ���� + 5��ŭ ���� �÷��� �� ���� �ִ뺼������ �۴ٸ� 
			volumeLevel += level;
			System.out.println("TV ������ " + level + "��ŭ �÷� ���� ������" + volumeLevel);
		} else { 
			int tempLevel = IVolume.TV_MAX_VOLUME - volumeLevel; // �ӽ÷����� �ִ�ġ�� �������� �� �ø� �� �ִ� ����. ex ���� 45, �ִ� 50�̸� templevel =5
			System.out.println("TV ������" + tempLevel + "��ŭ �÷� �ִ� ( " + TV_MAX_VOLUME + " ) �Դϴ�");
		}

	}

	@Override
	public void volumeDown() {
		if (volumeLevel > IVolume.TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV ������ 1��ŭ ���� ���� ����" + volumeLevel);						
		} else {
			System.out.println("TV ������ �ּ�ġ " + TV_MIN_VOLUME +  " �Դϴ�.");
		}

	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel - level > TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV ������ " + level + "��ŭ ����߷� ���� ���� " + volumeLevel + " �Դϴ�.");
		} else {
			int tempLevel = (volumeLevel - TV_MIN_VOLUME); // �ӽú����� ���� �������� �ּҺ����� �� 6. (���� 8��, �ּ� 6�ε� 10��ŭ ���� �� �����Ƿ�..)
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV ������" + tempLevel + " ��ŭ ������ ���� " + volumeLevel);

	}
	}
}
