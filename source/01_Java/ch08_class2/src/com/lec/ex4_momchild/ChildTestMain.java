package com.lec.ex4_momchild;

public class ChildTestMain {
	public static void main(String[] args) {
		Child c1 = new Child ("첫째 똘만이"); // c1이라는 객체에 name(똘만이) 과 mompouch, takemoney 메소드 정보가 있음.
		Child c2 = new Child ("둘째 똘순이"); // c2라는 객체에 name(똘순이) mompouch, takemoney
		Child c3 = new Child ("셋째 똘이"); // c3라는 객체에 똘이 name, mompouch, takemoney
		System.out.println("첫째 엄마 지갑 : " + c1.momPouch.money);
		System.out.println("둘째 엄마 지갑 : " + c2.momPouch.money);
		System.out.println("셋쨰 엄마 지갑 : " + c3.momPouch.money); // 세명 모두 mompouch의 money 데이터는 200으로 같음.
		
		c1.takeMoney(100); // 첫째가 100원을 빼간 경우
		System.out.println("남은 돈은 : " + c1.momPouch.money);
		c2.takeMoney(100); // 둘째가 100원을 빼간 경우
		System.out.println("남은 돈은 : " + c2.momPouch.money); // 분명 c1에서 100원 빼가서 100원이 남았어야 했는데 또 100원이 남음.
		c3.takeMoney(200);
		System.out.println("남은 돈은 : " + c3.momPouch.money);
		
		// static으로 mompouch의 값을 공유했다면 c1.momPouch.money... 등으로 입력할 필요 없이 child.mompouch.money 로 표시해도 같은 결과가 나옴.
		
	}
}
