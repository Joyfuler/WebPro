package com.lec.ex1_car;

import java.io.ObjectInputStream.GetField;

public class CarMain {
	public static void main(String[] args) {
		int i; // 해당 데이터가 직접 저장.
		String name = "홍"; // 해당 데이터의 번지수를 저장 (앞 변수가 대문자)
		Car myPorsche = new Car();

		// 마이포르쉐라는 변수를 저장. String과 마찬가지로 해당 주소가 저장되는 것.
		// car라는 클래스에 있는 컬러, cc, speed, park, drive, race 등 데이터를 모두 불러옴.

		// int[] arr = new int[3]; 다음과 같이 만드는 경우 {0,0,0} 으로 초기화됨.
		// 객체 데이터의 경우 더미데이터가 나오지 않고 000으로 데이터를 청소함.
		// 마찬가지로 new Car(); 로 불러오는 경우 string은 null, int는 0으로 초기화됨.

		// myPorsche.color = "빨강"; // private 넣고 getset넣은 후라면?
		myPorsche.setColor("빨강");

		// myPorsche.cc = 3000;
		myPorsche.setCc(3000);
		
		// System.out.println(myPorsche.color + "색 차 : " + myPorsche.cc + "cc, 속도: " + myPorsche.speed);
		System.out.println(myPorsche.getColor() + "색 차 : " + myPorsche.getCc() + "CC, 속도 : " + myPorsche.getSpeed());
		// private인 경우엔 set해서 값을 변경하고, get에서 return값을 넣은 후 메인에서 getcolor() 형식으로 불러올 수 있음.
	

		// myporsche의 speed를 아무것도 설정하지 않았기에 speed는 0이 출력됨.

		myPorsche.drive(); // 드라이브, 60으로 car 메소드에서 생성한 상태.
		System.out.println("--------------");
		myPorsche.race(); // 레이스, 120으로 변경됨.

		Car yourPorsche = new Car(); // yourPorche라는 새로운 변수생성. (car 클래스에 연결한)

		System.out.println("--------------");
		yourPorsche.setColor("그레이");
		yourPorsche.setCc(5000); // color를 null -> 그레이로, drive로 넣었으니 속도는 0 -> 60으로.
		System.out.println("너의 후진 포르쉐의 cc는 ㅋㅋ : " + yourPorsche.getCc());
		// 단, 이 과정에서 yourPorche에 들어간 값은 myPorche에 영향을 주지 않음. 위처럼 바꿔도 myPorche 값은 그대로
		// myPorsche.drive(); 라 적으면 색상은 원래 설정했던 빨간색이 나옴. 이를 인스턴스 변수라고 함.

	}

}
