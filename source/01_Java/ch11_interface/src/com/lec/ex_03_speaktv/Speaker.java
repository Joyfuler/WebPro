package com.lec.ex_03_speaktv;

public class Speaker implements IVolume {

	private int volumeLevel;

	public Speaker() {
		volumeLevel = 5; // tv를 켜면 볼륨을 항상 5로 초기화함.
	}

	@Override
	public void volumeUp() {

		if (volumeLevel < IVolume.SPEAKER_MAX_VOLUME) { // IVolume에 있는 맥스볼륨 상수값 소환
			volumeLevel++;
			System.out.println("speaker 볼륨을 1만큼 올려 현재 볼륨은" + volumeLevel);
		} else {
			System.out.println("speaker 볼륨이 최대치 ( " + IVolume.SPEAKER_MAX_VOLUME + " ) 이므로 올리지 못함");
		} // public이라면 IVolume을 사용하지 않아도 무관...
	}

	@Override
	public void volumeUp(int level) {

		if (volumeLevel + level < IVolume.SPEAKER_MAX_VOLUME) { // 현재 볼륨 + 5만큼 볼륨 올렸을 때 값이 최대볼륨보다 작다면
			volumeLevel += level;
			System.out.println("speaker 볼륨을 " + level + "만큼 올려 현재 볼륨은" + volumeLevel);
		} else {
			int tempLevel = IVolume.SPEAKER_MAX_VOLUME - volumeLevel; // 임시레벨은 최대치에 근접했을 때 올릴 수 있는 볼륨. ex 현재 45, 최대 50이면
																		// templevel =5
			System.out.println("speaker 볼륨을" + tempLevel + "만큼 올려 최대 ( " + SPEAKER_MAX_VOLUME + " ) 입니당");
		}

	}

	@Override
	public void volumeDown() {
		if (volumeLevel > IVolume.SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("speaker 볼륨을 1만큼 내려 현재 볼륨" + volumeLevel);
		} else {
			System.out.println("speaker 볼륨이 최소치 " + SPEAKER_MIN_VOLUME + " 입니다.");
		}

	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel - level > SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("speaker 볼륨을 " + level + "만큼 떨어뜨려 현재 볼륨 " + volumeLevel + " 입니다.");
		} else {
			int tempLevel = (volumeLevel - SPEAKER_MIN_VOLUME); // 임시볼륨은 현재 볼륨에서 최소볼륨을 뺀 6. (현재 8인, 최소 6인데 10만큼 줄일 수
																// 없으므로..)
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("speaker 볼륨을" + tempLevel + " 만큼 내려서 현재 " + volumeLevel);

		}
	}
}
