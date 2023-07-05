package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		Parent pObj1 = new Parent();
		Parent pObj2 = new Parent(10);
		System.out.println("두 객체가 같은지?" + pObj1.equals(pObj2)); // 다른 수이므로 당연히 false
		pObj1.method1();
		pObj2.method2();
		pObj2.method1();
		System.out.println("----------------------------------"); // parent에 들어가 있는 것이 모두 출력됨. 
		Child cObj1 = new Child (); // 매개변수가 없으므로 Parent() -> Child () 순서로.
		Child cObj2 = new Child (10); // Parent() -> Child (10) 순서로. (부모클래스는 매개변수 x)
		cObj1.method1(); // 오버라이드가 되었기에 parent의 메소드가 아닌 child의 메소드로 재정의하여 실행된 것.
		cObj2.method2(); // 오버라이드 없는 method2는 parent의 메소드에서 가져옴.
		cObj2.method3();
		// pObj1.method3(); // parents에 메소드3이 없으므로 당연히 오류
		System.out.println("두 객체가 같은지? " +cObj1.equals(cObj2)); // 아까 object를 true로 반환했으니 무조건 true가 나옴.
		System.out.println("----------------------------------");
		
		Parent obj = new Child(); // parent에서 상속받았으므로 parent 타입으로도 변경가능.
		obj.method1(); // Parent 타입이지만 Child에 있는 method를 실행함.
		obj.method2(); // Child에 없으므로 Parent에 있는 메소드 실행.
		// obj.method3(); // obj 변수의 타입이 parent이므로 나오는 문법적인 오류. 여기서 형변환을 통해 해결 가능.
		if (obj instanceof Child) { // 만일 child에 obj라는 객체(인스턴스)가 있다면
		((Child)obj).method3(); // 타입을 바꿔주는 식으로 ((타입)객체).메소드(); 형식으로 명시적인 형변환이 가능. 그냥 실행하면 문법적인 오류가 남.
		} else {
			System.out.println("형변환 불가"); // 이 경우에는 상속받았으므로 else는 출력되지 않음.
			// ** new 한 기준으로 메소드의 수행여부를 판단한다는 점에 주의할 것. 실제로 실행해봐야 여부를 알수 있음.
		}
	}
	
	
}
