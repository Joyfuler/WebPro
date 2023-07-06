package com.lec.ex03;

import com.lec.ex02.SuperClass;

// superclass(추상메소드포함한 추상클래스) : method1,2,3 // 
// ChildAbstractClass (추상을 오버라이드x, 물려받은 경우 역시 추상클래스) : method1,2,3,4 //
// GrandChild(일반클래스), 오버라이드완료 ↑  : method 1,2,3,4


public class TestMain {
	public static void main(String[] args) {
		SuperClass obj1 = new GrandChild(); // grandchild의 method1,2,3,4를 호출
		obj1.method1();
		obj1.method2();
		obj1.method3();
		// obj1.method4(); //  에러?! --> 형변환 필요. Superclass에는 method4가 없음...
		
		ChildAbstractClass obj2 = new GrandChild();
		obj2.method1();
		obj2.method2();
		obj2.method3();
		obj2.method4(); // obj2는 모두 가능. childabstractclass에서 메소드4를 따로 오버라이드 했기 떄문.
	}
}


