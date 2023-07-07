package com.lec.ex01;
//인터페이스1 : NUM상수, 메소드1
//인터페이스2: STRING상수, 메소드2
public class TestMain {
	public static void main(String[] args) {
		// InterfaceEx1 ex1 = new InterfaceEx1(); 불가
	ClassEx obj = new ClassEx();
	obj.method1();
	obj.method2();
	InterfaceEx1 obj1 = new ClassEx();
	obj.method1();
	// obj.method2();  // 형변환을 해준다면 가능하지만...
	
	InterfaceEx2 obj2 = new ClassEx();
	obj2.method2();
	// obj2.method1(); // 해당 클래스로 가보면 있지만, 인터페이스Ex2에는 메소드1이 없으므로 오류..
	System.out.println("CONSTANT_NUM : " + InterfaceEx1.CONSTANT_NUM); // 원본에 있는 상수를 그대로 써도 되고,
	System.out.println("CONSTANT_NUM : " + ClassEx.CONSTANT_NUM); // 상속받은 classEX에서 써도 됨.
	System.out.println(("CONSTANT_NUM : " + obj.CONSTANT_NUM)); // 단, static이라면 객체보단 class로 접근하는 것을 추천.
	System.out.println("CONSTANT_STRING : " + ClassEx.CONSTANT_STRING);
	System.out.println("CONSTANT_STRING : " + InterfaceEx2.CONSTANT_STRING); 
	
	}
}
