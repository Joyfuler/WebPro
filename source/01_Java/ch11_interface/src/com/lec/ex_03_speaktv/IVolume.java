package com.lec.ex_03_speaktv;

// �������̽� - �۾����� ����. (���� JSP-Spring�� ���� Ȱ��..)
// �������̽�: ���(static final ����), �߻�޼ҵ常 �� �� ����. ��, default, static �޼ҵ�� ��밡��
public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int TV_MIN_VOLUME = 2;
	public int SPEAKER_MAX_VOLUME = 100;
	public int SPEAKER_MIN_VOLUME = 0;

	public void volumeUp(); // ������ 1�� ���ϴ� �޼ҵ�

	public void volumeUp(int level); // ������ level��ŭ ���ϴ� �޼ҵ�. �����ε�

	public void volumeDown(); // ����1�ٿ�

	public void volumeDown(int level); // ������ level��ŭ ������ �޼ҵ�. �����ε�

	public default void setMute(boolean mute) { // ����Ʈ �޼ҵ��̹Ƿ� ����� ��������
		if (mute) {
			System.out.println("����");
		} else {
			System.out.println("���� ����");
		}
	}
		
		public static void changeBattery() { // ����ƽ �޼ҵ��̹Ƿ� ����� ����
			System.out.println("�������� ��ȯ�մϴ�.");
		}
	}

