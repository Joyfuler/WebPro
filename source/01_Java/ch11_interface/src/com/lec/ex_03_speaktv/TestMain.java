package com.lec.ex_03_speaktv;

public class TestMain {
	public static void main(String[] args) {
		Speaker speaker = new Speaker();
		Tv tv = new Tv();
		IVolume[] devices = {speaker, tv}; // 둘의 변수는 다르지만 둘 다 Ivolume에서 받아왔기 때문에 IVolume 배열로 통일가능.
	
		for (IVolume device : devices) { // Ivolume이라는 타입의 devices를 정렬. iVolume이라는 것에 대입
				device.volumeUp();
				device.volumeUp(50);
				device.volumeDown();
				device.volumeDown(30);
				device.setMute(true); // setmute에 true를 하면 무음.
				device.setMute(false);
		}
			IVolume.changeBattery(); // static 메소드...
		
		
		
	}
}
