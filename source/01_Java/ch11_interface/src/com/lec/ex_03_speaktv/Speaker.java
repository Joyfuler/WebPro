package com.lec.ex_03_speaktv;

public class Speaker implements IVolume {

	private int volumeLevel;

	public Speaker() {
		volumeLevel = 5; // tv�� �Ѹ� ������ �׻� 5�� �ʱ�ȭ��.
	}

	@Override
	public void volumeUp() {

		if (volumeLevel < IVolume.SPEAKER_MAX_VOLUME) { // IVolume�� �ִ� �ƽ����� ����� ��ȯ
			volumeLevel++;
			System.out.println("speaker ������ 1��ŭ �÷� ���� ������" + volumeLevel);
		} else {
			System.out.println("speaker ������ �ִ�ġ ( " + IVolume.SPEAKER_MAX_VOLUME + " ) �̹Ƿ� �ø��� ����");
		} // public�̶�� IVolume�� ������� �ʾƵ� ����...
	}

	@Override
	public void volumeUp(int level) {

		if (volumeLevel + level < IVolume.SPEAKER_MAX_VOLUME) { // ���� ���� + 5��ŭ ���� �÷��� �� ���� �ִ뺼������ �۴ٸ�
			volumeLevel += level;
			System.out.println("speaker ������ " + level + "��ŭ �÷� ���� ������" + volumeLevel);
		} else {
			int tempLevel = IVolume.SPEAKER_MAX_VOLUME - volumeLevel; // �ӽ÷����� �ִ�ġ�� �������� �� �ø� �� �ִ� ����. ex ���� 45, �ִ� 50�̸�
																		// templevel =5
			System.out.println("speaker ������" + tempLevel + "��ŭ �÷� �ִ� ( " + SPEAKER_MAX_VOLUME + " ) �Դϴ�");
		}

	}

	@Override
	public void volumeDown() {
		if (volumeLevel > IVolume.SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("speaker ������ 1��ŭ ���� ���� ����" + volumeLevel);
		} else {
			System.out.println("speaker ������ �ּ�ġ " + SPEAKER_MIN_VOLUME + " �Դϴ�.");
		}

	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel - level > SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("speaker ������ " + level + "��ŭ ����߷� ���� ���� " + volumeLevel + " �Դϴ�.");
		} else {
			int tempLevel = (volumeLevel - SPEAKER_MIN_VOLUME); // �ӽú����� ���� �������� �ּҺ����� �� 6. (���� 8��, �ּ� 6�ε� 10��ŭ ���� ��
																// �����Ƿ�..)
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("speaker ������" + tempLevel + " ��ŭ ������ ���� " + volumeLevel);

		}
	}
}
