package com.lec.ex4_object;

// 순서 - 데이터, 생성자, 메소드(일반, getset,오버라이드)
// new Card("♥",3) 방식으로 생성할 예정.
public class Card {

	private String kind;
	private int num;

	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		return "[카드는] : " + kind + "-" + num;
	}

	public boolean equals(Object obj) {
		// c1.equals(c2)의 결과가, c1은 (this(kind)가 되고, c2가 obj로 산입됨.
		// this.kind와 obj.kind가 같은지를 check. // 같은 모양인지?
		// (this.num)과 obj.num이 같은지도 체크. // 같은 숫자인지??
		// 둘다 같을 때, return kindChk && numChk

		if (obj != null && obj instanceof Card) {
			Card other = (Card) obj; // 형변환.
			boolean kindChk = (kind.equals(((Card) obj).kind));
			boolean numChk = (num == (other.num));
			return (kindChk && numChk);
		}
		return false;

	}

}
