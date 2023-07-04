package com.lec.ex3_product;

public class ProductTestMain {

	public static void main(String[] args) {
		System.out.println("스태틱 변수는 :" + Product.count);
		//
		Product.staticMethod(); // 따로 객체를 만들거나 하지  않아도 바로 실행됨. static이란 공유라는 의미.
		Product p1 = new Product(); // 객체를 만드는 경우 = static에 있던 메모리도 p1에 함께 들어감.
		p1.infoPrint(); // 시리얼 넘버와 공유변수 count의 결과가 동일.
		Product p2 = new Product(); // static에 있던 메모리 (p1에 있던 값과 카운트)가 p2에 들어감. (p2에 할당된 Product 메소드 + static 메소드)
		System.out.println("static 변수 :" + Product.count); // count에 +1이 되었으므로  (102로 생성)
		p2.infoPrint(); // 결과 101+1 이 되어 102로 변경됨.
		new Product(); // 간단한 식으로 이어서 변수를 만들어낼 수 있음.
		System.out.println("static 변수 :" + p1.count);
		System.out.println("static 변수 :" + p2.count);
		
		// 따라서 static은 다수의 매개변수가 공유하는 데이터임. 메모리 점유율이 높으므로 1개씩만 쓸 것. 여러개 쓰는 경우 속도가 매우 느려짐...     
		
		
	}
}
