package com.lec.ex4_object;

public class Ex3_CardMain {
	public static void main(String[] args) {
		Card c1 = new Card("♥", 3);
		Card c2 = new Card("♥", 3);
		Card c3 = null;
		String s = "홍길";
		
		System.out.println(c1);
		System.out.println(c2);
		//toSting 오버라이드는 어떤 데이터가 들어갔는지 확인하는 용도로도 자주 사용하게 됨. 항상 사용하도록..
		int i=10, j=10;
		System.out.println("i와 j가 같나? " + (i==j)); 
		// int 변수 등 소문자 타입인 경우는 ==을 사용가능. 그러나 String 등 대문자 타입이라면 equals를 사용해야 함.
		System.out.println("c1과 c2가 같은 주소냐? " + (c1==c2)); // x, 서로 다른 객체이므로 당연히 false. 주소를 비교하는 식
		System.out.println("c1과 c2가 같은 '카드(데이터값)'냐? " + (c1.equals(c2))); // 그냥 실행하면 다시 주소를 비교함. 따라서 equals를 오버라이드해줘야함.
		System.out.println("c1이라는 c3는 같은가?" + (c1.equals(c3))); // c3 는 null이므로 값 자체가 다름.	return false;
	}
}
