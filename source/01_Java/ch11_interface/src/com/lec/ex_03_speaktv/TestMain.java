package com.lec.ex_03_speaktv;

public class TestMain {
	public static void main(String[] args) {
		Speaker speaker = new Speaker();
		Tv tv = new Tv();
		IVolume[] devices = {speaker, tv}; // ���� ������ �ٸ����� �� �� Ivolume���� �޾ƿԱ� ������ IVolume �迭�� ���ϰ���.
	
		for (IVolume device : devices) { // Ivolume�̶�� Ÿ���� devices�� ����. iVolume�̶�� �Ϳ� ����
				device.volumeUp();
				device.volumeUp(50);
				device.volumeDown();
				device.volumeDown(30);
				device.setMute(true); // setmute�� true�� �ϸ� ����.
				device.setMute(false);
		}
			IVolume.changeBattery(); // static �޼ҵ�...
		
		
		
	}
}
