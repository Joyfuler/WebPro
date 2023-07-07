package com.lec.ex_03_speaktv;

// 인터페이스 - 작업명세서 역할. (추후 JSP-Spring을 통해 활용..)
// 인터페이스: 상수(static final 변수), 추상메소드만 올 수 있음. 단, default, static 메소드는 사용가능
public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int TV_MIN_VOLUME = 2;
	public int SPEAKER_MAX_VOLUME = 100;
	public int SPEAKER_MIN_VOLUME = 0;

	public void volumeUp(); // 볼륨을 1씩 업하는 메소드

	public void volumeUp(int level); // 볼륨을 level만큼 업하는 메소드. 오버로딩

	public void volumeDown(); // 볼륨1다운

	public void volumeDown(int level); // 볼륨을 level만큼 내리는 메소드. 오버로딩

	public default void setMute(boolean mute) { // 디폴트 메소드이므로 사용이 가능해짐
		if (mute) {
			System.out.println("무음");
		} else {
			System.out.println("무음 해제");
		}
	}
		
		public static void changeBattery() { // 스태틱 메소드이므로 사용이 가능
			System.out.println("건전지를 교환합니다.");
		}
	}

