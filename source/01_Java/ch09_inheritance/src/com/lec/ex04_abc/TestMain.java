package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // S 생성자 함수만 실행됨.
		// S타입, 타입 변수(새로운 이름) = new 있던 객체();
		// A aObj = new A();
		S aObj = new A(); // 타입을 S로 통일해도 가능.. 생성자 함수가 2개 실행됨. (부모단, 자식단 1개씩)
		S bObj = new B(); // 마찬가지로 생성자 함수가 2개 실행. (S,B)
		C cObj = new C(); // S타입이 아닌 C타입으로 생성...?!
		
		S[] arr = {sObj, aObj, bObj, cObj}; // C타입이지만 동시에 S의 상속을 받았으므로 동일하게 배열을 생성할 수 있음.
		for (int idx = 0; idx < arr.length; idx++) {
			System.out.println(idx + "번째: " + arr[idx].s); //arr[idx]의 s 변수 반복실행
		}
		
		for (S a : arr) { // arr의 배열을 a로 카피하는 것이 확장 for문.
			System.out.println("s= " + a.s); // arr[idx]를 a로 카피했으므로 a를 그대로 사용하면 됨.
		}
	}
}
