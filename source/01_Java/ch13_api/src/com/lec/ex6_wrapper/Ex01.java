package com.lec.ex6_wrapper;

import com.lec.ex4_object.Card;

public class Ex01 {
	public static void main(String[] args) {
		Card c1 = new Card("♥", 3);
		Card c2 = new Card("♥", 3);
		int i = 10; // int는 객체 데이터가 아닌데도 가능해?!
		Integer iObj = new Integer(10); // 사실은 이렇게 자동생성되는 것.
		double d = 2.2;
		Double dObj = new Double(2.2); // 와 동일함.
		// 예외인듯? 객체에 10넣으면 원래 그대로 출력이 안되겠지만...?
		System.out.println(iObj);
		//System.out.println(c1.equals(i));
		System.out.println(c1.equals(10)); // 이렇게 넣어도 되는 이유는 new Integer(10)이 자동으로 산입되기 때문임.
		System.out.println(c1.equals(2.2)); // 이렇게 넣어도 new Double(2.2)가 자동으로 산입됨. 이것이 Wrapper...?
		System.out.println(c1.equals(true)); // new boolean (true) 식으로 객체가 만들어지는 것임.
		// 즉, Wrapper는 기초 데이터와 객체 데이터의 사이를 왕래할 수 있는 것.
		//i = iObj; // 실은 iObj.intValue(); 로 객체를 가져오는 것.. 
	}
}
