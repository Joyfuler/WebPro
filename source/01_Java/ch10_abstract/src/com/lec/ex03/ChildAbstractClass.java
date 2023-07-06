package com.lec.ex03;

import com.lec.ex02.SuperClass;

// method1(추상), method2(일반), method3(일반) 불러온것.
public abstract class ChildAbstractClass extends SuperClass { // 상속받은 곳에 이미 추상메소드 method1이 있으므로, 오류발생. abstract 추가
	public void method4() {
		System.out.println("ChildAbstractClass의 method4");
	} // 추상클래스의 객체를 만들기 위해선 반드시 오버라이드를 해야함.

}
